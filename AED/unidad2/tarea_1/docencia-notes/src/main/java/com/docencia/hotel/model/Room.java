package com.docencia.hotel.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "number")
    private int number;
    @Column(name = "type")
    private String type;
    @Column(name = "price_per_night")
    private double price;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel Hotel;


    public Room() {
    }

    public Room(int id) {
        this.id = id;
    }

    public Room(int id, int number, String type, double price, Hotel Hotel) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.price = price;
        this.Hotel = Hotel;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Hotel getHotel() {
        return this.Hotel;
    }

    public void setHotel(Hotel Hotel) {
        this.Hotel = Hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Room)) {
            return false;
        }
        Room room = (Room) o;
        return Objects.equals(id, room.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
