package com.tiendaonline.service;

import com.tiendaonline.model.ClienteDetalles;
import com.tiendaonline.model.Pedido;
import com.tiendaonline.repository.ClienteDetalleRepository;
import com.tiendaonline.service.interfaces.IClienteDetallesService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteDetallesService implements IClienteDetallesService{

    private ClienteDetalleRepository clienteDetalleRepository;

    @Autowired
    public void setClienteDetalleRepository(ClienteDetalleRepository clienteDetalleRepository) {
        this.clienteDetalleRepository = clienteDetalleRepository;
    }

    @Override
    public Optional<ClienteDetalles> findByClienteId(int clienteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByClienteId'");
    }

    @Override
    public ClienteDetalles saveDetallesForCliente(int cliente_id, ClienteDetalles detalles) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveDetallesForCliente'");
    }


   
}
