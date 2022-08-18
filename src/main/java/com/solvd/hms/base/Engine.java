package com.solvd.hms.base;

import java.util.Objects;

public class Engine {

    private Integer number;
    private Double volume;
    private String fuel;

    public Engine(Integer number, Double volume) {
        this.number = number;
        this.volume = volume;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "Engine{" + "number=" + number + ", volue=" + volume + ", fuel='" + fuel + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Engine)) return false;
        Engine engine = (Engine) o;
        return Objects.equals(getNumber(), engine.getNumber()) && Objects.equals(getVolume(), engine.getVolume()) && Objects.equals(getFuel(), engine.getFuel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getVolume(), getFuel());
    }
}
