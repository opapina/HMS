package com.solvd.hms.vehicle;

import base.Engine;

import java.util.Objects;

public class Car extends Vehicle {

    private Engine engine;

    public Car(String model, String brand) {
        super(model, brand);
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" + "engine=" + engine + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(getEngine(), car.getEngine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEngine());
    }
}
