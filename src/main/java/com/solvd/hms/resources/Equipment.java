package com.solvd.hms.resources;

import java.math.BigDecimal;
import java.util.Objects;

public class Equipment {

    private String name;
    private String typeService;
    private BigDecimal price;

    public Equipment(String name, String typeService, BigDecimal price) {
        this.name = name;
        this.typeService = typeService;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Equipment{" + "name='" + name + '\'' + ", typeService='" + typeService + '\'' + ", price=" + price + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipment)) return false;
        Equipment equipment = (Equipment) o;
        return getName().equals(equipment.getName()) && Objects.equals(getTypeService(), equipment.getTypeService());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getTypeService());
    }
}
