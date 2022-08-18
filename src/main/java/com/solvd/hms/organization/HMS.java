package com.solvd.hms.organization;

import com.solvd.hms.base.Address;
import com.solvd.hms.client.Client;
import com.solvd.hms.exception.InvalidListException;
import com.solvd.hms.order.Order;
import com.solvd.hms.resources.*;
import com.solvd.hms.service.Service;
import com.solvd.hms.vehicle.Car;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class HMS extends Organization implements AutoCloseable {

    private static final Logger LOGGER = LogManager.getLogger(HMS.class);

    private final List<Service> services;
    private List<Order<?>> orders;
    private List<Address> addresses;
    private List<Worker> workers;
    private List<Equipment> equipments;
    private List<Client<Address, Car>> clients;

    public HMS(String name, Integer number, Address address, List<Address> addresses, List<Service> services) {
        super(name, number, address);
        if (addresses.size() == 0) {
            throw new InvalidListException("The list is empty");
        } else this.addresses = addresses;
        this.services = services;
    }

    @Override
    public void close() {
        LOGGER.info("Object is moved to garbage");
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Worker> getWorker() {
        return workers;
    }

    public void setWorker(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Equipment> getEquipment() {
        return equipments;
    }

    public void setEquipment(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public List<Order<?>> getOrder() {
        return orders;
    }

    public void setOrders(List<Order<?>> orders) {
        this.orders = orders;
    }

    public List<Client<Address, Car>> getClient() {
        return clients;
    }

    public void setClient(List<Client<Address, Car>> clients) {
        this.clients = clients;
    }

    public List<Service> getServices() {
        return services;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HMS)) return false;
        if (!super.equals(o)) return false;
        HMS hms = (HMS) o;
        return getServices().equals(hms.getServices()) && orders.equals(hms.orders) && getAddresses().equals(hms.getAddresses()) && workers.equals(hms.workers) && equipments.equals(hms.equipments) && clients.equals(hms.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getServices(), orders, getAddresses(), workers, equipments, clients);
    }
}
