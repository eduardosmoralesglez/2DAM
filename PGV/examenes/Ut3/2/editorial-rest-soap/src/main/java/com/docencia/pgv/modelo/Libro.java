package com.docencia.pgv.modelo;

import java.util.Objects;

public class Libro {

    private Long id;
    private String titulo;
    private Integer anioPublicacion;
    private Long idAutor;

    /**
     * Constructo por defecto
     */
    public Libro() {
    }

    /**
     * Constructor identificador
     * @param id Long con el identificador
     */
    public Libro(Long id) {
        this.id = id;
    }

    /**
     * Constructor general
     * @param id Long con el identificador
     * @param titulo String con el titulo
     * @param anioPublicacion Integer con el anio de publicacion 
     * @param idAutor Long con el ID del autor
     */
    public Libro(Long id, String titulo, Integer anioPublicacion, Long idAutor) {
        this.id = id;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.idAutor = idAutor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Libro)) {
            return false;
        }
        Libro libro = (Libro) o;
        return Objects.equals(id, libro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
