package com.solvd.hms.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class GarbageRemoval extends Service {

    public static int countRemoval;
    private String garbageType;
    private BigDecimal quantity;
    private LocalDate dateRemoval;

    public GarbageRemoval(String type, String place, String garbageType, BigDecimal quantity) {
        super(type, place);
        this.garbageType = garbageType;
        this.quantity = quantity;
        this.dateRemoval = LocalDate.now();
        countRemoval++;
    }

    public GarbageRemoval(String type, String place, String garbageType, BigDecimal quantity, LocalDate dateRemoval) {
        super(type, place);
        this.quantity = quantity;
        this.dateRemoval = dateRemoval;
        this.garbageType = garbageType;
        countRemoval++;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDateRemoval() {
        return dateRemoval;
    }

    public void setDateRemoval(LocalDate dateRemoval) {
        this.dateRemoval = dateRemoval;
    }

    public String getGarbageType() {
        return garbageType;
    }

    public void setGarbageType(String garbageType) {
        this.garbageType = garbageType;
    }

    public void sort(String garbageType) {
        if (garbageType == "Plastic") {
            setPlace("Plastic container");
        } else if (garbageType == "Glass") {
            setPlace("Glass container");
        } else if (garbageType == "Paper") {
            setPlace("Paper container");
        } else {
            setPlace("Common container");
        }
    }

    public void sort(String place, String garbageType) {
        if (garbageType == "Plastic") {
            setPlace("Plastic container");
            System.out.println("This is the Plastic container");
        } else if (garbageType == "Glass") {
            setPlace("Glass container");
            System.out.println("This is the Glass container");
        } else if (garbageType == "Paper") {
            setPlace("Paper container");
            System.out.println("This is the Paper container");
        } else {
            setPlace("Common container");
            System.out.println("This is the Common container");
        }
    }

    public String getTypeService() {
        return this.type;
    }

    @Override
    public String toString() {
        return "GarbageRemoval{" + "garbageType='" + garbageType + '\'' + ", quantity=" + quantity + ", dateRemoval=" + dateRemoval + ", type='" + type + '\'' + ", place='" + place + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GarbageRemoval)) return false;
        GarbageRemoval that = (GarbageRemoval) o;
        return Objects.equals(getGarbageType(), that.getGarbageType()) && Objects.equals(getQuantity(), that.getQuantity()) && Objects.equals(getDateRemoval(), that.getDateRemoval());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGarbageType(), getQuantity(), getDateRemoval());
    }
}
