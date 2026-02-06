package com.biblioteca.model;

import jakarta.persistence.*;
import java.time.LocalDate;

//LA TABLA SE DEBE DE LLAMAR SOCIO
@Entity
@Table(name = "SOCIO")
public class Socio {

    private Long id;

    private String nombre;

    private String email;

    private LocalDate fechaAlta;

    public Socio() {
    }

    public Socio(Long id) {
        this.id = id;
    }

    public Socio(Long id, String nombre, String email, LocalDate fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaAlta = fechaAlta;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "socio_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "fechaAlta")
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}
