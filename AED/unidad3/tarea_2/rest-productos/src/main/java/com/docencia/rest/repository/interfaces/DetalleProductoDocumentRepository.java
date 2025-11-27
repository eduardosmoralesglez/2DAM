package com.docencia.rest.repository.interfaces;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.docencia.rest.modelo.DetalleProductoDocument;

@Repository
public interface DetalleProductoDocumentRepository extends MongoRepository<DetalleProductoDocument, Integer>{
    //Optional<DetalleProductoDocument> findByProductoId(Long productoId);
    //DetalleProductoDocument save(Long productoId, DetalleProductoDocument detalle);
    //void deleteByProductoId(Long productoId);
}