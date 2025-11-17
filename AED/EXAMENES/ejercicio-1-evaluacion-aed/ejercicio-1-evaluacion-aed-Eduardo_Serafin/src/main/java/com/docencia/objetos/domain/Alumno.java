package com.docencia.objetos.domain;
import java.util.Objects;

public class Alumno {
  private Long id;
  private String nombre;
  private String email;
  private String ciclo;
  private Rol rol;   


  /**
   * Constructor por defecto
   */
  public Alumno() {
  }

  /**
   * Constructor sin rol
   * @param id
   * @param nombre
   * @param email
   * @param ciclo
   */
  public Alumno(Long id, String nombre, String email, String ciclo) {
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
  public Alumno(Long id, String nombre, String email, String ciclo, Rol rol) {
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

  public Rol getRol() {
    return this.rol;
  }

  public void setRol(Rol rol) {
    this.rol = rol;
  }

  public Alumno id(Long id) {
    setId(id);
    return this;
  }

  public Alumno nombre(String nombre) {
    setNombre(nombre);
    return this;
  }

  public Alumno email(String email) {
    setEmail(email);
    return this;
  }

  public Alumno ciclo(String ciclo) {
    setCiclo(ciclo);
    return this;
  }

  public Alumno rol(Rol rol) {
    setRol(rol);
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alumno)) {
            return false;
        }
        Alumno alumno = (Alumno) o;
        return Objects.equals(id, alumno.id);
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