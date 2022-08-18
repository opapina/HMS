package com.solvd.hms.base;

import java.util.Objects;

public class Apartment {

    private Integer room;
    private Double square;
    private Address address;

    public Apartment(Integer room, double square, Address address) {
        this.room = room;
        this.square = square;
        this.address = address;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Double getSquare() {
        return square;
    }

    public void setSquare(Double square) {
        this.square = square;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Apartment{" + "room=" + room + ", square=" + square + ", address=" + address + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apartment)) return false;
        Apartment apartment = (Apartment) o;
        return Objects.equals(getRoom(), apartment.getRoom()) && Objects.equals(getSquare(), apartment.getSquare()) && Objects.equals(getAddress(), apartment.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoom(), getSquare(), getAddress());
    }
}
