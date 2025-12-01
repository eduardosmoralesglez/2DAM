package com.tiendaonline.service;

import com.tiendaonline.model.Cliente;
import com.tiendaonline.repository.ClientesRepository;
import com.tiendaonline.service.interfaces.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService{

    private ClientesRepository clientesRepository;

    @Autowired
    public void setClientesRepository(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @Override
    public List<Cliente> findAllSortedByNombre() {
        return clientesRepository.findAllSortedByNombre();
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return clientesRepository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clientesRepository.save(cliente);
    }

    @Override
    public void deleteById(Integer id) {
        Cliente clienteAEliminar = new Cliente(id);
        clientesRepository.delete(clienteAEliminar);
    }


}
