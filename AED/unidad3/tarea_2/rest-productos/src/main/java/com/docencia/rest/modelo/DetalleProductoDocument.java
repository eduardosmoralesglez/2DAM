package com.docencia.rest.modelo;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "producto_detalle")
public class DetalleProductoDocument {
    @Id
    private String id;
    private Long productoId;
    private String descripcionLarga;
    private Map<String, String> especificacionesTecnicas;
    private List<String> tags;
    
}