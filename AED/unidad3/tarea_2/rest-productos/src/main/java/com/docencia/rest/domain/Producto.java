package com.docencia.rest.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Producto {
    private int id;
    private String nombre;
    private BigDecimal precio;
    private int stock;
    private DetalleProducto detalleProducto;

    /**
     * Constructor por defecto
     */
    public Producto() {
    }
    
    /**
     * Constructor identificador
     * @param id
     */
    public Producto(int id) {
        this.id = id;
    }

    /**
     * Constructor general
     * @param id
     * @param nombre
     * @param precio
     * @param stock
     */
    public Producto(int id, String nombre, BigDecimal precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

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

    public BigDecimal getPrecio() {
        return this.precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Producto)) {
            return false;
        }
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
