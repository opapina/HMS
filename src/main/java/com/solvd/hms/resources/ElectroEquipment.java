package com.solvd.hms.resources;

import java.math.BigDecimal;
import java.util.Objects;

public class ElectroEquipment extends Equipment {

    private Integer power;

    public ElectroEquipment(String name, String typeService, BigDecimal price, Integer power) {
        super(name, typeService, price);
        this.power = power;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "ElectroEquipment{" + "power=" + power + "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectroEquipment)) return false;
        if (!super.equals(o)) return false;
        ElectroEquipment that = (ElectroEquipment) o;
        return Objects.equals(getPower(), that.getPower());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPower());
    }
}
