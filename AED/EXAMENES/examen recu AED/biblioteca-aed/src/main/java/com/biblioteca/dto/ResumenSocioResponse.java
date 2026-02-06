package com.biblioteca.dto;

import com.biblioteca.model.Socio;
import com.biblioteca.model.mongo.SocioDetalles;

import java.util.List;

public class ResumenSocioResponse {
    public Socio socio;
    public SocioDetalles detalles;
    public List<PrestamoActivoItem> prestamosActivos;

    public static class PrestamoActivoItem {
        public Long prestamoId;
        public Long libroId;
        public String isbn;
        public String titulo;
        public java.time.LocalDate fechaInicio;
    }
}
