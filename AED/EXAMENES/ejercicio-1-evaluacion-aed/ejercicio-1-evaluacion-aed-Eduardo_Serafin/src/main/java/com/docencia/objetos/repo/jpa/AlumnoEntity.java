package com.docencia.objetos.repo.jpa;

import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name="alumnos")
public class AlumnoEntity {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  
  @Column(unique = true)
  private String email;
  
  private String ciclo;

  private RolEntity rol;

  /**
   * Constructor por defecto
   */
  public AlumnoEntity() {
  }

  /**
   * Constructor sin rol
   * @param id
   * @param nombre
   * @param email
   * @param ciclo
   */
  public AlumnoEntity(Long id, String nombre, String email, String ciclo) {
    this.id = id;
    this.nombre = nombre;
    this.email = email;
    this.ciclo = ciclo;
  }

  /**
   * Constructor general
   * @param id
   * @param nombre
   * @param email
   * @param ciclo
   * @param rol
   */
  public AlumnoEntity(Long id, String nombre, String email, String ciclo, RolEntity rol) {
    this.id = id;
    this.nombre = nombre;
    this.email = email;
    this.ciclo = ciclo;
    this.rol = rol;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCiclo() {
    return this.ciclo;
  }

  public void setCiclo(String ciclo) {
    this.ciclo = ciclo;
  }

  public RolEntity getRol() {
    return this.rol;
  }

  public void setRol(RolEntity rol) {
    this.rol = rol;
  }

  public AlumnoEntity id(Long id) {
    setId(id);
    return this;
  }

  public AlumnoEntity nombre(String nombre) {
    setNombre(nombre);
    return this;
  }

  public AlumnoEntity email(String email) {
    setEmail(email);
    return this;
  }

  public AlumnoEntity ciclo(String ciclo) {
    setCiclo(ciclo);
    return this;
  }

  public AlumnoEntity rol(RolEntity rol) {
    setRol(rol);
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AlumnoEntity)) {
            return false;
        }
        AlumnoEntity alumnoEntity = (AlumnoEntity) o;
        return Objects.equals(id, alumnoEntity.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", nombre='" + getNombre() + "'" +
      ", email='" + getEmail() + "'" +
      ", ciclo='" + getCiclo() + "'" +
      ", rol='" + getRol() + "'" +
      "}";
  }



}
