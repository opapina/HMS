package com.solvd.hms.service;

import java.util.Objects;

public abstract class Service {

    public Type type;
    public String place;

    public enum Type {
        CLEANING("Cleaning"), GARBAGEREMOVAL("GarbageRemoval"), RENOVATIONOFPREMISSES("RenovationOfPremises"), REPAIRINOUTLETPIPES("RepairInOutLetPipes"), REPAIRINOUTLETWIRES("RepairInOutLetWires");

        private final String displayName;

        Type(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public Service(Type type, String place) {
        this.type = type;
        this.place = place;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Service{" + "type='" + type + '\'' + ", place='" + place + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;
        Service service = (Service) o;
        return Objects.equals(getType(), service.getType()) && Objects.equals(getPlace(), service.getPlace());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getPlace());
    }
}
