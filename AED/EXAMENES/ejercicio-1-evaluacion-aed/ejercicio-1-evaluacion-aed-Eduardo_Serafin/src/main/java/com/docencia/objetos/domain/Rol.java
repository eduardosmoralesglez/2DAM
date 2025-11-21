package com.docencia.objetos.domain;
import java.util.Objects;

public class Rol {

  private Long id;
  private String nombre;

  /**
   * Constructor por defecto
   */
  public Rol() {
  }

  /**
   * Constructo identificador
   * @param id
   */
  public Rol(Long id) {
    this.id = id;
  }

  /**
   * Constructo general
   * @param id
   * @param nombre
   */
  public Rol(Long id, String nombre) {
    this.id = id;
    this.nombre = nombre;
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

  public Rol id(Long id) {
    setId(id);
    return this;
  }

  public Rol nombre(String nombre) {
    setNombre(nombre);
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Rol)) {
            return false;
        }
        Rol rol = (Rol) o;
        return Objects.equals(id, rol.id);
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
      "}";
  }

  
}
