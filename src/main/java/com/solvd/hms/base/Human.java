package com.solvd.hms.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Human implements IAsk, IMove {

    private static final Logger LOGGER = LogManager.getLogger(Human.class);

    private final String firstName;
    private final String lastName;
    private LocalDate dob;

    public Human(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public abstract void ask();

    public abstract void say();

    @Override
    public void go() {
        LOGGER.info("Human go ahead!");
    }

    @Override
    public void jump() {
        LOGGER.info("Human jump!");
    }

    @Override
    public void run() {
        LOGGER.info("Human run!");
    }

    @Override
    public void dance() {
        LOGGER.info("Human dance!");
    }

    @Override
    public void askHelp() {
        LOGGER.info("I would like if you help, please");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Human{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", dob=" + dob + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return Objects.equals(getFirstName(), human.getFirstName()) && Objects.equals(getDob(), human.getDob());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getDob());
    }
}
