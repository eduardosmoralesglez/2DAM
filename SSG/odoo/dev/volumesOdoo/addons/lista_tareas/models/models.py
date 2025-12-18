# -*- coding: utf-8 -*-

from odoo import models, fields, api
from dateutil.relativedelta import relativedelta

# Definimos el modelo de datos
class ListaTareas(models.Model):
    # Nombre y descripción del modelo de datos
    _name = 'lista_tareas.lista_tareas'
    _description = 'Lista de tareas'

    # Elementos de cada fila del modelo de datos
    tarea = fields.Char(string='Tarea')
    prioridad = fields.Integer(string='Prioridad')
    urgente = fields.Boolean(
        string='Urgente',
        compute='_value_urgente',
        store=True
    )
    
    # Usuario asignado y si esta realizada
    asignado_a = fields.Many2one("res.users",string='Persona asignada', default= lambda self:self.env.user,required= True)
    realizada = fields.Boolean(string='Realizada')

    # Campos de fecha y Retraso
    fecha_limite = fields.Date(string='Fecha limite', default=fields.Date.today()+ relativedelta(months=+1))
    fecha_creacion = fields.Date(string='Fecha creacion', default=fields.Date.today())
    retrasada = fields.Boolean(
        string='Retrasada',
        compute='_tarea_retrasada'
    )

    # Este cómputo depende de la variable prioridad
    @api.depends('prioridad')
    def _value_urgente(self):
        # Para cada registro
        for record in self:
            # Si la prioridad es mayor que 10, se considera urgente
            record.urgente = record.prioridad > 10
    
    @api.depends('fecha_limite')
    def _tarea_retrasada(self):
        # Para cada registro
        for record in self:
            record.retrasada = record.fecha_limite < fields.Date.today() and record.realizada:
                 
            
