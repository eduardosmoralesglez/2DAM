package com.tiendaonline.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clientes")
public class Cliente {

    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;

    private List<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(int id, String nombre, String email, List<Pedido> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.pedidos = pedidos;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
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

    @OneToMany
    @JoinColumn(name = "pedidos")
    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
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
            ", pedidos='" + getPedidos() + "'" +
            "}";
    }
    
    
}
