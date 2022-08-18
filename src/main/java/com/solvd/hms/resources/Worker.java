package com.solvd.hms.resources;

import base.*;
import exception.ExperienceInvalidException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vehicle.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Worker extends Human implements IDo, IWork {

    private static final Logger LOGGER = LogManager.getLogger(Worker.class);

    private String profession;
    private Integer experience;
    private BigDecimal salaryPerMonth;
    private Address address;
    private List<Vehicle> vehicles;
    private List<Child> children;

    public Worker(String firstName, String lastName, LocalDate dob, String profession, Integer experience) throws ExperienceInvalidException {
        super(firstName, lastName, dob);
        this.profession = profession;
        this.experience = experience;
        if (experience == 0) {
            throw new ExperienceInvalidException("Experience should be 1 or more years");
        }
        int age = LocalDate.now().getYear() - dob.getYear();
        if (age < 18) {
            throw new ExperienceInvalidException("Age less 18,change the year");
        }
    }

    @Override
    public void think() {
        LOGGER.info("How it could be done?");
    }

    @Override
    public void operate() {
        LOGGER.info("do working");
    }

    @Override
    public void doOrder() {
        LOGGER.info("Go to client and do order");
    }

    @Override
    public void tellOfOrder() {
        LOGGER.info("You are welcome!");
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) throws ExperienceInvalidException {
        if (experience == 0) {
            throw new ExperienceInvalidException("Experience should be 1 or more years");
        }
        this.experience = experience;
    }

    public BigDecimal getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(BigDecimal salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Vehicle> getVehicle() {
        return vehicles;
    }

    public void setVehicle(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public void ask() {
        LOGGER.info("Yes, I can help you");
    }

    @Override
    public void say() {
        LOGGER.info("I am doing  ");
    }

    @Override
    public String toString() {
        return "Worker{" + "profession='" + profession + '\'' + ", experience=" + experience + ", salaryPerMonth=" + salaryPerMonth + ", address=" + address + ", vehicles=" + vehicles + ", children=" + children + "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return getProfession().equals(worker.getProfession()) && getExperience().equals(worker.getExperience()) && getSalaryPerMonth().equals(worker.getSalaryPerMonth()) && getAddress().equals(worker.getAddress()) && vehicles.equals(worker.vehicles) && getChildren().equals(worker.getChildren());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getProfession(), getExperience(), getSalaryPerMonth(), getAddress(), vehicles, getChildren());
    }
}
