package com.docencia.rest.modelo;

import java.util.List;
import java.util.Map;

public class DetalleProducto {
    private String descripcionLarga;
    private Map<String, String> especificacionesTecnicas;
    private List<String> tags;


    public String getDescripcionLarga() {
        return this.descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    public Map<String,String> getEspecificacionesTecnicas() {
        return this.especificacionesTecnicas;
    }

    public void setEspecificacionesTecnicas(Map<String,String> especificacionesTecnicas) {
        this.especificacionesTecnicas = especificacionesTecnicas;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }


}