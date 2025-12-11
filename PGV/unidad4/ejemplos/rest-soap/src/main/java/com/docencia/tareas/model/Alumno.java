package com.docencia.tareas.model;

import jakarta.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement(name = "alumno")
@XmlAccessorType(XmlAccessType.FIELD)
public class Alumno {
    private String nombre;
    private Long identificador;


    public Alumno() {
    }

    public Alumno(Long identificador) {
        this.identificador = identificador;
    }

    public Alumno(String nombre, Long identificador) {
        this.nombre = nombre;
        this.identificador = identificador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alumno)) {
            return false;
        }
        Alumno alumno = (Alumno) o;
        return Objects.equals(identificador, alumno.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", identificador='" + getIdentificador() + "'" +
            "}";
    }
    
}
