package com.solvd.hms.client;

import com.solvd.hms.base.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Client<A, V> extends Human implements IDrive, IDo {

    private static final Logger LOGGER = LogManager.getLogger(Client.class);

    private List<A> apartments;
    private List<V> vehicles;
    private List<Child> children;

    public Client(String firstName, String lastName, LocalDate dob, List<Apartment> apartments) {
        super(firstName, lastName, dob);
    }

    public void ask() {
        LOGGER.info("Could you please do something");
    }

    public void say() {
        LOGGER.info("Thank you for your help");
    }

    @Override
    public void doOrder() {
        LOGGER.info("call by phone and make order request");
    }

    @Override
    public void tellOfOrder() {
        LOGGER.info("Thank you very much");
    }

    @Override
    public void turnKey() {
        LOGGER.info("Key is turned");
    }

    @Override
    public void turnSteeringWheel() {
        LOGGER.info("SteeringWheel is turned");
    }

    public List<A> getApartment() {
        return apartments;
    }

    public void setApartment(List<A> apartment) {
        this.apartments = apartment;
    }

    public List<V> getVehicle() {
        return vehicles;
    }

    public void setVehicle(List<V> vehicle) {
        this.vehicles = vehicle;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Client{" + "apartments=" + apartments + ", vehicles=" + vehicles + ", children=" + children + "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        if (!super.equals(o)) return false;
        Client<A, V> client = (Client<A, V>) o;
        return apartments.equals(client.apartments) && vehicles.equals(client.vehicles) && getChildren().equals(client.getChildren());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), apartments, vehicles, getChildren());
    }

    public String getLastName() {
        return null;
    }
}
