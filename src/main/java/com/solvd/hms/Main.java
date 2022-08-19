package com.solvd.hms;

import com.solvd.hms.client.Client;
import com.solvd.hms.base.Address;
import com.solvd.hms.base.Apartment;
import com.solvd.hms.base.IDo;
import com.solvd.hms.base.IMove;
import com.solvd.hms.exception.ExperienceInvalidException;
import com.solvd.hms.order.Order;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hms.organization.HMS;
import com.solvd.hms.resources.Equipment;
import com.solvd.hms.resources.ElectroEquipment;
import com.solvd.hms.resources.Worker;
import com.solvd.hms.service.Cleaning;
import com.solvd.hms.service.GarbageRemoval;
import com.solvd.hms.service.Service;
import com.solvd.hms.vehicle.Truck;
import com.solvd.hms.vehicle.Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
//        FileWriter fw = new FileWriter( "Mysterious.rtf" );
//        fw.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr1 = new FileReader( "Mockingjay.txt" );
        String name;
        int c;
        System.out.println("Print File Files.txt? y/n");
        name = br.readLine();
        if(name.equals("y"))
            while ((c = fr1.read()) != -1) System.out.println((char) c);
        fr1.close();

        Truck truck1 = new Truck("TGL", "MAN");
        Client<Address, Car> mrJon = new Client<>("Alex", "Jon", LocalDate.of(1999, 3, 6), List.of(new Apartment(2, 55.25, new Address("Frunze", 78, 24))));
        Client<Address, Car> mrKozlov = new Client<>("Sasha", "Kozlov", LocalDate.of(2005, 6, 8), List.of(new Apartment(1, 35, new Address("Kozlova", 25, 10))));
        Client<Address, Car> mrPupsik = new Client<>("Ivan", "Pupsik", LocalDate.of(2002, 12, 21), List.of(new Apartment(3, 40, new Address("Zaharova", 40, 21))));
        Set<Client<Address, Car>> clients = new HashSet<>();
        clients.add(mrJon);
        clients.add(mrPupsik);
        clients.add(mrPupsik);
        clients.add(mrKozlov);

        for (Client<Address, Car> client : clients) {
            LOGGER.info(client.getLastName());
        }

        Worker piperVasia;
        try {
            piperVasia = new Worker("Vasia", "Kovaliov", LocalDate.of(2002, 1, 1), "piper", 12);
        } catch (ExperienceInvalidException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        } finally {
            piperVasia = new Worker("Vasia", "Kovaliov", LocalDate.of(2002, 1, 1), "piper", 12);
        }

        Worker welderKolya = new Worker("Kolya", "Ivanov", LocalDate.of(2004, 6, 6), "welder", 1);
        Worker cleanerPetya = new Worker("Petya", "Shevcov", LocalDate.of(2003, 4, 20), "cleaner", 5);
        Worker welderVanya = new Worker("Vanya", "Ivanov", LocalDate.of(2000, 6, 6), "welder", 8);
        Set<Worker> workers = new HashSet<>();
        workers.add(piperVasia);
        workers.add(cleanerPetya);
        workers.add(cleanerPetya);
        workers.add(welderKolya);
        workers.add(welderVanya);

        for (Worker worker : workers) {
            LOGGER.info(worker.getFirstName());
        }

        Address pervomaiskay = new Address("Pervomaiskay");
        Address zaharova = new Address("Zaharova");
        Address pulihova = new Address("Pulihova");
        Address frunze = new Address("Frunze");
        Address chapaeva = new Address("Chapaeva");

        List<Address> addresses = new ArrayList<>();
        addresses.add(pervomaiskay);
        addresses.add(zaharova);
        addresses.add(pulihova);
        addresses.add(frunze);
        addresses.add(chapaeva);

        for (Address addresses1 : addresses) {
            LOGGER.info(addresses1);
        }

        Map<String, Address> map = new HashMap<>();
        map.put("First quarter", zaharova);
        map.put("Second quarter", pervomaiskay);
        map.put("Third quarter", pulihova);
        map.put("Fourth quarter", chapaeva);
        map.put("Fifth quarter", frunze);
        map.put("Second quarter", frunze);
        map.put("Sixth quarter", pervomaiskay);
        map.put("First quarter", chapaeva);
        map.put("Seventh quarter", zaharova);

        for (String key : map.keySet()) {
            LOGGER.info(key + ":" + map.get(key));
        }

        Service dryOfHall = new Cleaning("cleaning", "hall", "dry", 2, BigDecimal.valueOf(25.06));
        Service streetGR1 = new GarbageRemoval("garbage removal", "Street", "Plastic", BigDecimal.valueOf(67.90), LocalDate.of(2022, 07, 12));
        Service streetGR2 = new GarbageRemoval("garbage removal", "Street", "Food Garbage", BigDecimal.valueOf(50.00), LocalDate.of(2022, 07, 13));

        List<Service> services = new ArrayList<>();
        services.add(dryOfHall);
        services.add(streetGR1);
        services.add(streetGR2);
        for (Service serviceList : services) {
            LOGGER.info(serviceList);
        }

        Order<Equipment> order1 = new Order<>(1, "cleaning", new Address("Chapaeva", 25, 70));
        Order<Equipment> order2 = new Order<>(2, "garbageRemoval", new Address("Kozlova", 50, 45));
        Order<ElectroEquipment> order3 = new Order<>(3, "TVrepair", new Address("Frunze", 50, 45));

        List<Order<?>> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        for (Order<?> orders1 : orders) {
            LOGGER.info(orders1);
        }

        IDo iDo1 = new Worker("Zhenya", "Ivanov", LocalDate.of(1982, 1, 1), "piper", 17);
        IDo iDo2 = new Client<Address, Car>("Nikolay", "Bubnov", LocalDate.of(1999, 3, 5), List.of(new Apartment(3, 100, new Address("Nezavisimosti", 15, 4))));
        IMove iMove2 = new Worker("Zhenya", "Ivanov", LocalDate.of(1982, 1, 1), "piper", 17);

        HMSUtils.communicate(mrJon);

        HMSUtils.doSmth(iDo1);

        HMSUtils.doSmth(iDo2);

        HMSUtils.move(iMove2);

        try (HMS partizanskiHMS = new HMS("PartizanskiHMS", 34, new Address("Rumyanceva", 37, 2), addresses, services)) {

            List<Integer> res = new ArrayList<>();
            List<Integer> results = new ArrayList<>(orders.size());
            for (Order<?> orders1 : orders) {
                res.add(HMSUtils.checkService(orders1, partizanskiHMS));
            }

            for (int i = 0; i < orders.size(); i++) {
                if (res.get(i) == 1) {
                    LOGGER.info("Order " + orders.get(i) + " can be done");
                } else {
                    LOGGER.info("Order " + orders.get(i) + " can't be done");
                }
            }
        }
    }
}


