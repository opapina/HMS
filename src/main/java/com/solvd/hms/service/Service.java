package com.solvd.hms.service;

import java.util.Objects;

public abstract class Service {

    public String type;
    public String place;

    public Service(String type, String place) {
        this.type = type;
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
