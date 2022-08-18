package com.solvd.hms.organization;

import com.solvd.hms.base.Address;

import java.util.Objects;

public class Organization {

    private String name;
    private Integer number;
    private Address address;

    public Organization(String name, Integer number, Address address) {
        this.name = name;
        this.number = number;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organization{" + "name='" + name + '\'' + ", number=" + number + ", address=" + address + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization)) return false;
        Organization that = (Organization) o;
        return getName().equals(that.getName()) && getNumber().equals(that.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getNumber());
    }
}
