package org.formacion.procesos.service;

import org.formacion.procesos.components.IFicheroComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Procesos {

    
    IFicheroComponent componentFichero;

    @Autowired
    public void setComonentFichero(IFicheroComponent component) {
        this.componentFichero = component;
    }

    public void ejecutar() {
        System.out.println("Ejecutando lógica del proceso...");
        System.out.println(componentFichero.mensaje());
    }
    
}