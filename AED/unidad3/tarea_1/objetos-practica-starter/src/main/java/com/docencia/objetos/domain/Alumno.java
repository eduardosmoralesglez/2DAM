package com.docencia.objetos.domain;
import java.util.Objects;

public class Alumno {
  private Long id;
  private String nombre;
  private String email;
  private String ciclo;

  /**
   * Constructor por defecto
   */
  public Alumno() {
  }

  /**
   * Constructor identificador
   * @param id
   */
  public Alumno(Long id) {
    this.id = id;
  }

  /**
   * Constructor general
   * @param id del alumno
   * @param nombre del alumno
   * @param email del alumno
   * @param ciclo del alumno
   */
  public Alumno(Long id, String nombre, String email, String ciclo) {
    this.id = id;
    this.nombre = nombre;
    this.email = email;
    this.ciclo = ciclo;
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

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alumno)) {
            return false;
        }
        if (id == null || getId() == null) {
          return false;
        }
        Alumno alumno = (Alumno) o;
        return Objects.equals(id, alumno.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}
