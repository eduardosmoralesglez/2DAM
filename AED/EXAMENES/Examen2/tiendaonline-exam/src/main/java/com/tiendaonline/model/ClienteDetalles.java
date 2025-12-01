package com.tiendaonline.model;
import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cliente_detalles")
public class ClienteDetalles {

    private String id;

    private int clienteId;

    private String telefono;

    private String notasInternas;

    public ClienteDetalles() {
    }

    public ClienteDetalles(String id, int clienteId, String telefono, String notasInternas) {
        this.id = id;
        this.clienteId = clienteId;
        this.telefono = telefono;
        this.notasInternas = notasInternas;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getClienteId() {
        return this.clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNotasInternas() {
        return this.notasInternas;
    }

    public void setNotasInternas(String notasInternas) {
        this.notasInternas = notasInternas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClienteDetalles)) {
            return false;
        }
        ClienteDetalles clienteDetalles = (ClienteDetalles) o;
        return Objects.equals(id, clienteDetalles.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", clienteId='" + getClienteId() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", notasInternas='" + getNotasInternas() + "'" +
            "}";
    }
    

   }
