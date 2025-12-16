package com.docencia.pgv.modelo;
import java.util.Objects;

public class Autor {

    private Long id;
    private String nombre;
    private String pais;

    /**
     * Constructor por defecto
     */
    public Autor() {
    }

    /**
     * Constructor identificador
     * @param id Long con el identificador
     */
    public Autor(Long id) {
        this.id = id;
    }

    /**
     * Constrictor general
     * @param id Long con el identificador
     * @param nombre String con el nombre
     * @param pais String con el pais
     */
    public Autor(Long id, String nombre, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Autor)) {
            return false;
        }
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    


}
