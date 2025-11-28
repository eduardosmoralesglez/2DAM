package com.docencia.rest.mappers;


import org.mapstruct.Mapper;

import com.docencia.rest.domain.DetalleProducto;
import com.docencia.rest.modelo.DetalleProductoDocument;

@Mapper(componentModel = "spring")
public interface DetalleProductoMapper {

    DetalleProductoDocument toDocument(DetalleProducto detalle);

    DetalleProducto toDocument(DetalleProductoDocument document);
    
}