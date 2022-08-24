package com.solvd.hms.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Cleaning extends Service {

    private Type type;
    private Integer surfaceDirection;
    private BigDecimal squareMeters;
    private LocalDateTime dateTimeCleaning;

    public Cleaning(Type type, String place, String typeCleaning, Integer surfaceDirection, BigDecimal squareMeters) {
        super(type, place);
        this.dateTimeCleaning = LocalDateTime.now();
        this.squareMeters = squareMeters;
        this.type = type;
        this.surfaceDirection = surfaceDirection;
    }

    public Cleaning(Type type, String place, String typeCleaning, Integer surfaceDirection, BigDecimal squareMeters, LocalDateTime dateTimeCleaning) {
        super(type, place);
        this.squareMeters = squareMeters;
        this.dateTimeCleaning = dateTimeCleaning;
        this.type = type;
        this.surfaceDirection = surfaceDirection;
    }

    public static void dust(String placeOfCleaning1, Integer surfaceDirection1) {
        System.out.print("Dust was removed in" + placeOfCleaning1 + " ");
        if (surfaceDirection1 == 1) {
            System.out.println("from walls");
        } else {
            System.out.println("from furniture");
        }
    }

    public Integer getSurfaceDirection() {
        return surfaceDirection;
    }

    public void setSurfaceDirection(Integer surfaceDirection) {
        this.surfaceDirection = surfaceDirection;
    }

    public BigDecimal getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(BigDecimal squareMeters) {
        this.squareMeters = squareMeters;
    }

    public LocalDateTime getDateTimeCleaning() {
        return dateTimeCleaning;
    }

    public void setDateTimeCleaning(LocalDateTime dateTimeCleaning) {
        this.dateTimeCleaning = dateTimeCleaning;
    }

    public BigDecimal wash(String placeOfCleaning, Boolean surfaceDirection, BigDecimal squareMeters) {
        return squareMeters;
    }

    public BigDecimal sweep(String placeOfCleaning, BigDecimal squareMeters) {
        return squareMeters;
    }

    public Type getTypeService() {
        return this.type;
    }

    @Override
    public String toString() {
        return "Cleaning{" + "typeCleaning='" + type + '\'' + ", surfaceDirection=" + surfaceDirection + ", squareMeters=" + squareMeters + ", dateTimeCleaning=" + dateTimeCleaning + ", type='" + type + '\'' + ", place='" + place + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cleaning)) return false;
        Cleaning cleaning = (Cleaning) o;
        return Objects.equals(getType(), cleaning.getType()) && Objects.equals(getSurfaceDirection(), cleaning.getSurfaceDirection()) && Objects.equals(getSquareMeters(), cleaning.getSquareMeters()) && Objects.equals(getDateTimeCleaning(), cleaning.getDateTimeCleaning());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getSurfaceDirection(), getSquareMeters(), getDateTimeCleaning());
    }
}
