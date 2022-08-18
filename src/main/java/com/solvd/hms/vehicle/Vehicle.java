package com.solvd.hms.vehicle;

import exception.InvalidCountWheelException;

import java.util.Objects;

public abstract class Vehicle {

    private String model;
    private String brand;
    private Integer wheelsCount;

    public Vehicle(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getWheelsCount() {
        return wheelsCount;
    }

    public void setWheelsCount(Integer wheelsCount) {
        if (wheelsCount == 0) {
            throw new InvalidCountWheelException("Vehicle should have wheels! Input number from 1 to 4:");
        }
        this.wheelsCount = wheelsCount;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "model='" + model + '\'' + ", brand='" + brand + '\'' + ", wheel=" + wheelsCount + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(getModel(), vehicle.getModel()) && Objects.equals(getBrand(), vehicle.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getBrand());
    }
}
