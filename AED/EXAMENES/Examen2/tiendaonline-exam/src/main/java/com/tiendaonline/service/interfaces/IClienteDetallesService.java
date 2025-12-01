package com.tiendaonline.service.interfaces;

import java.util.Optional;

import com.tiendaonline.model.ClienteDetalles;

public interface IClienteDetallesService {
    public Optional<ClienteDetalles> findByClienteId(int clienteId);
    public ClienteDetalles saveDetallesForCliente(int cliente_id, ClienteDetalles detalles);
}
