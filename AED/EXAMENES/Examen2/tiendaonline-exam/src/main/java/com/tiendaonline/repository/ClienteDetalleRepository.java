package com.tiendaonline.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tiendaonline.model.ClienteDetalles;

public interface ClienteDetalleRepository extends MongoRepository<ClienteDetalles, Integer>{

}
