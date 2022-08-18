package com.solvd.hms.service;

import java.util.Objects;

public class RepairInOutLetWires extends Service {

    private Double longW;

    public RepairInOutLetWires(String type, String place, Double longW) {
        super(type, place);
        this.longW = longW;
    }

    public Double getLongW() {
        return longW;
    }

    public void setLongW(Double longW) {
        this.longW = longW;
    }

    public String getTypeService() {
        return this.type;
    }

    @Override
    public String toString() {
        return "RepairInOutLetWires{" + "longW=" + longW + ", type='" + type + '\'' + ", place='" + place + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RepairInOutLetWires)) return false;
        RepairInOutLetWires that = (RepairInOutLetWires) o;
        return Objects.equals(getLongW(), that.getLongW());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLongW());
    }
}
