package com.solvd.hms.service;

import java.util.Objects;

public class RepairInOutLetPipes extends Service {

    private String material;
    private Double longP;
    private Double diameter;

    public RepairInOutLetPipes(String type, String place, String material, Double longP, Double diameter) {
        super(type, place);
        this.material = material;
        this.longP = longP;
        this.diameter = diameter;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getLongP() {
        return longP;
    }

    public void setLongP(Double longP) {
        this.longP = longP;
    }

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    public String getTypeService() {
        return this.type;
    }

    @Override
    public String toString() {
        return "RepairInOutLetPipes{" + "material='" + material + '\'' + ", longP=" + longP + ", diameter=" + diameter + ", type='" + type + '\'' + ", place='" + place + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RepairInOutLetPipes)) return false;
        RepairInOutLetPipes that = (RepairInOutLetPipes) o;
        return Objects.equals(getMaterial(), that.getMaterial()) && Objects.equals(getLongP(), that.getLongP()) && Objects.equals(getDiameter(), that.getDiameter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaterial(), getLongP(), getDiameter());
    }
}
