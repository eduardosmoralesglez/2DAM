package com.tiendaonline.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pedidos")
public class Pedido {

    private int id;

    @Column(name = "estado")
    private String estado;

    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(int id, String estado, Cliente cliente) {
        this.id = id;
        this.estado = estado;
        this.cliente = cliente;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @JoinColumn(name = "cliente_id", nullable = false)
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pedido)) {
            return false;
        }
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", estado='" + getEstado() + "'" +
            ", cliente='" + getCliente() + "'" +
            "}";
    }
    
}
