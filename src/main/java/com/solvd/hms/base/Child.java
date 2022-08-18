package com.solvd.hms.base;

import java.time.LocalDate;
import java.util.Objects;

public class Child extends Human implements IAsk, IMove {

    private Integer infantAge;

    public Child(String firstName, String lastName, LocalDate dob) {
        super(firstName, lastName, dob);
    }

    public Integer getInfantAge() {
        return infantAge;
    }

    public void setInfantAge(Integer infantAge) {
        this.infantAge = infantAge;
    }

    @Override
    public String toString() {
        return "Child{" + "infantAge=" + infantAge + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Child)) return false;
        Child child = (Child) o;
        return getInfantAge().equals(child.getInfantAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInfantAge());
    }

    public void ask() {
        System.out.println("Can I play");

    }

    public void say() {
        System.out.println("I want to play");

    }
}
