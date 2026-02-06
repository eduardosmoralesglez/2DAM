package com.biblioteca.model;

import jakarta.persistence.*;
import java.time.LocalDate;

//LA TABLA SE DEBE DE LLAMAR PRESTAMO_LIBRO
@Entity
@Table(name = "PRESTAMO_LIBRO")
public class Prestamo {

    private Long id;

    private Socio socio;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    private PrestamoEstado estado;

    public Prestamo() {
    }

    public Prestamo(Long id) {
        this.id = id;
    }

    public Prestamo(Long id, Socio socio, LocalDate fechaInicio, LocalDate fechaFin, PrestamoEstado estado) {
        this.id = id;
        this.socio = socio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "socio_id")
    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    @Column(name = "fechaInicial")
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Column(name = "fechaFin")
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Column(name = "estado")
    public PrestamoEstado getEstado() {
        return estado;
    }

    public void setEstado(PrestamoEstado estado) {
        this.estado = estado;
    }
}
