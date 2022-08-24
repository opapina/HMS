package com.solvd.hms.service;

import java.time.LocalDateTime;
import java.util.Objects;

public class RenovationOfPremises extends Service {

    private Float heightOfWalls;
    private Float widthOfWalls;
    private Double squaresOfFloor;
    private Integer quantityOfWindows;
    private Integer quantityOfDoors;
    private LocalDateTime timeOfRenovation;

    public RenovationOfPremises(Type type, String place, Float heightOfWalls, Float widthOfWalls, Double squaresOfFloor, Integer quantityOfWindows, Integer quantityOfDoors) {
        super(type, place);
        this.timeOfRenovation = LocalDateTime.now();
        this.heightOfWalls = heightOfWalls;
        this.widthOfWalls = widthOfWalls;
        this.squaresOfFloor = squaresOfFloor;
        this.quantityOfWindows = quantityOfWindows;
        this.quantityOfDoors = quantityOfDoors;
    }

    public Float getHeightOfWalls() {
        return heightOfWalls;
    }

    public void setHeightOfWalls(Float heightOfWalls) {
        this.heightOfWalls = heightOfWalls;
    }

    public Float getWidthOfWalls() {
        return widthOfWalls;
    }

    public void setWidthOfWalls(Float widthOfWalls) {
        this.widthOfWalls = widthOfWalls;
    }

    public Double getSquaresOfFloor() {
        return squaresOfFloor;
    }

    public void setSquaresOfFloor(Double squaresOfFloor) {
        this.squaresOfFloor = squaresOfFloor;
    }

    public Integer getQuantityOfWindows() {
        return quantityOfWindows;
    }

    public void setQuantityOfWindows(Integer quantityOfWindows) {
        this.quantityOfWindows = quantityOfWindows;
    }

    public Integer getQuantityOfDoors() {
        return quantityOfDoors;
    }

    public void setQuantityOfDoors(Integer quantityOfDoors) {
        this.quantityOfDoors = quantityOfDoors;
    }

    public LocalDateTime getTimeOfRenovation() {
        return timeOfRenovation;
    }

    public void timeOfRenovation(LocalDateTime timeOfRenovation) {
        this.timeOfRenovation = timeOfRenovation;
    }

    public Type getTypeService() {
        return type;
    }

    @Override
    public String toString() {
        return "RenovationOfPremises{" + "heightOfWalls=" + heightOfWalls + ", widthOfWalls=" + widthOfWalls + ", squaresOfFloor=" + squaresOfFloor + ", quantityOfWindows=" + quantityOfWindows + ", quantityOfDoors=" + quantityOfDoors + ", timeOfRenovation=" + timeOfRenovation + ", type='" + type + '\'' + ", place='" + place + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RenovationOfPremises)) return false;
        RenovationOfPremises that = (RenovationOfPremises) o;
        return Objects.equals(getHeightOfWalls(), that.getHeightOfWalls()) && Objects.equals(getWidthOfWalls(), that.getWidthOfWalls()) && Objects.equals(getSquaresOfFloor(), that.getSquaresOfFloor()) && Objects.equals(getQuantityOfWindows(), that.getQuantityOfWindows()) && Objects.equals(getQuantityOfDoors(), that.getQuantityOfDoors()) && Objects.equals(getTimeOfRenovation(), that.getTimeOfRenovation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeightOfWalls(), getWidthOfWalls(), getSquaresOfFloor(), getQuantityOfWindows(), getQuantityOfDoors(), getTimeOfRenovation());
    }
}
