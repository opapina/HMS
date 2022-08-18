package com.solvd.hms.vehicle;

import com.solvd.hms.base.Engine;

import java.util.Objects;

public class Truck extends Vehicle {

    private Engine engine;
    private String typeTruck;

    public Truck(String model, String brand) {
        super(model, brand);
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getTypeTruck() {
        return typeTruck;
    }

    public void setTypeTruck(String typeTruck) {
        this.typeTruck = typeTruck;
    }

    @Override
    public String toString() {
        return "Truck " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Truck)) return false;
        Truck truck = (Truck) o;
        return Objects.equals(getEngine(), truck.getEngine()) && Objects.equals(getTypeTruck(), truck.getTypeTruck());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEngine(), getTypeTruck());
    }
}

