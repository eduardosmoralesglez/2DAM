package com.docencia.tareas.model;

import java.util.Objects;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "tarea")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tarea {

    private long id;
    private String titulo;
    private String descripcion;
    private boolean completado;

    /**
     * Constructor por defecto
     */
    public Tarea() {
    }

    /**
     * Constructor identificador
     * 
     * @param id
     */
    public Tarea(long id) {
        this.id = id;
    }

    /**
     * Constructor por defecto
     * 
     * @param id
     * @param titulo
     * @param descripcion
     * @param completado
     */
    public Tarea(long id, String titulo, String descripcion, boolean completado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completado = completado;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletado() {
        return this.completado;
    }

    public boolean getCompletado() {
        return this.completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Tarea)) {
            return false;
        }
        Tarea tarea = (Tarea) o;
        return Objects.equals(id, tarea.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", titulo='" + getTitulo() + "'" +
                ", descripcion='" + getDescripcion() + "'" +
                ", completado='" + isCompletado() + "'" +
                "}";
    }

}
