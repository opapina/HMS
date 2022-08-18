package com.solvd.hms.base;

import java.util.Objects;

public class Address {

    private String street;
    private Integer house;
    private Integer apartment;

    public Address(String street) {
        this.street = street;
    }

    public Address(String street, Integer house, Integer apartment) {
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getApartment() {
        return apartment;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Address{" + "street='" + street + '\'' + ", house=" + house + ", apartment=" + apartment + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getHouse(), address.getHouse()) && Objects.equals(getApartment(), address.getApartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStreet(), getHouse(), getApartment());
    }
}
