package com.tiendaonline.service;

import com.tiendaonline.model.Cliente;
import com.tiendaonline.model.Pedido;
import com.tiendaonline.repository.PedidoRepository;
import com.tiendaonline.service.interfaces.IPedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PedidoService implements IPedidoService{

    private PedidoRepository pedidoRepository;

    @Autowired
    public void setPedidoRepository(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido crearPedido(Integer clienteId, String estado) {
        Cliente clientePedido = new Cliente(clienteId);
        Pedido pedidoACrear = new Pedido(0, estado, clientePedido);
        return pedidoRepository.save(pedidoACrear);
    }

    @Override
    public Pedido findById(Long id) {
        return pedidoRepository.findById(id.intValue()).orElse(null);
    }

    
}
