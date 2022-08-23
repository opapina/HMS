package com.solvd.hms.vehicle;

import java.util.Objects;

public abstract class Vehicle {

    private String model;
    private String brand;
    private WheelsCount wheelsCount;

    public enum WheelsCount {
        ONE(1), TWO(2), THREE(3), FOUR(4);

        private final Integer count;

        WheelsCount(Integer count) {
            this.count = count;
        }

        public Integer getCount() {
            return count;
        }
    }

    public Vehicle(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    public Vehicle(String model, String brand, WheelsCount wheelsCount) {
        this.model = model;
        this.brand = brand;
        this.wheelsCount = wheelsCount;
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

    public void setWheelsCount(WheelsCount wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    public WheelsCount getWheelsCount() {
        return wheelsCount;
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
