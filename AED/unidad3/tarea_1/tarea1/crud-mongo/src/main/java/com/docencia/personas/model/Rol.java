package com.docencia.personas.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "roles")
public class Rol {

    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    public Rol() {
    }
 
    public Rol(String id) {
     this.id = id;
    }
    
    /**
     * Constructor de la clase con propiedades
     * @param id String. ID unico del Rol.
     * @param nombre String. Nombre del Rol.
     */
    public Rol(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Rol)) {
            return false;
        }
        Rol rol = (Rol) o;
        return Objects.equals(id, rol.id);
    }
    

}
