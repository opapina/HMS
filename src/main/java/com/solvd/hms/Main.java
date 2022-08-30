package com.solvd.hms;

import com.solvd.hms.base.*;
import com.solvd.hms.client.Client;
import com.solvd.hms.exception.ExperienceInvalidException;
import com.solvd.hms.order.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.hms.organization.HMS;
import com.solvd.hms.resources.Equipment;
import com.solvd.hms.resources.ElectroEquipment;
import com.solvd.hms.resources.Worker;
import com.solvd.hms.service.Cleaning;
import com.solvd.hms.service.GarbageRemoval;
import com.solvd.hms.service.Service;
import com.solvd.hms.vehicle.*;
import org.apache.logging.log4j.util.Supplier;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.*;

import static com.solvd.hms.HMSUtils.*;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Client<Apartment, Car> mrJon = new Client<>("Alex", "Jon", LocalDate.of(1999, 3, 6), List.of(new Apartment(2, 55.25, new Address("Frunze", 78, 24))));
        Client<Apartment, Car> mrKozlov = new Client<>("Sasha", "Kozlov", LocalDate.of(2005, 6, 8), List.of(new Apartment(1, 35, new Address("Kozlova", 25, 10))));
        Client<Apartment, Car> mrPupsik = new Client<>("Ivan", "Pupsik", LocalDate.of(2002, 12, 21), List.of(new Apartment(3, 40, new Address("Zaharova", 40, 21))));
        Set<Client<Apartment, Car>> clients = new HashSet<>();
        clients.add(mrJon);
        clients.add(mrPupsik);
        clients.add(mrPupsik);
        clients.add(mrKozlov);

        clients.stream()
                .forEach(c -> LOGGER.info(c.toString()));

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

        workers.stream()
                .forEach(worker -> LOGGER.info(worker.getFirstName() + " " + worker.getLastName() + " is a " + worker.getProfession()));

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

        addresses.stream()
                .forEach(address -> LOGGER.info(address.getStreet()));

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

        map.keySet().stream()
                .forEach(key -> LOGGER.info(key + ":" + map.get(key)));

        map.keySet().stream()
                .filter(m -> map.get(m).equals(frunze))
                .forEach(m -> LOGGER.info(m + "  " + map.get(m)));

        String keyName = String.valueOf(map.keySet().stream()
                .filter(m -> map.get(m).equals(chapaeva))
                .findFirst());

        LOGGER.info(keyName + "  " + chapaeva);

        Service dryOfHall = new Cleaning(Service.Type.CLEANING, "hall", "dry", 2, BigDecimal.valueOf(25.06));
        Service streetGR1 = new GarbageRemoval(Service.Type.GARBAGEREMOVAL, "Street", GarbageRemoval.GarbageType.PLASTIC, BigDecimal.valueOf(67.90), LocalDate.of(2022, 07, 12));
        Service streetGR2 = new GarbageRemoval(Service.Type.GARBAGEREMOVAL, "Street", GarbageRemoval.GarbageType.WASTE, BigDecimal.valueOf(50.00), LocalDate.of(2022, 07, 13));

        List<Service> services = new ArrayList<>();
        services.add(dryOfHall);
        services.add(streetGR1);
        services.add(streetGR2);

        services.stream()
                .forEach(service -> LOGGER.info(service.getType()));

        Order<Equipment> order1 = new Order<>(1, Service.Type.CLEANING, new Address("Chapaeva", 25, 70));
        Order<Equipment> order2 = new Order<>(2, Service.Type.GARBAGEREMOVAL, new Address("Kozlova", 50, 45));
        Order<ElectroEquipment> order3 = new Order<>(3, Service.Type.REPAIRINOUTLETWIRES, new Address("Frunze", 50, 45));

        List<Order<?>> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        orders.stream()
                .forEach(order -> LOGGER.info(order));

        IDo iDo1 = new Worker("Zhenya", "Ivanov", LocalDate.of(1982, 1, 1), "piper", 17);
        IDo iDo2 = new Client<Apartment, Car>("Nikolay", "Bubnov", LocalDate.of(1999, 3, 5), List.of(new Apartment(3, 100, new Address("Nezavisimosti", 15, 4))));
        IMove iMove2 = new Worker("Zhenya", "Ivanov", LocalDate.of(1982, 1, 1), "piper", 17);

        HMSUtils.communicate(mrJon);

        HMSUtils.doSmth(iDo2);

        switch (streetGR1.getType()) {
            case CLEANING:
                LOGGER.info("Worker do cleaning");
                HMSUtils.doSmth(iDo1);
                break;
            case GARBAGEREMOVAL:
                LOGGER.info("Worker move and look after the process");
                HMSUtils.move(iMove2);
                break;
            case REPAIRINOUTLETPIPES:
                HMSUtils.doSmth(piperVasia);
                break;
            case REPAIRINOUTLETWIRES:
                HMSUtils.move(welderKolya);
                break;
            case RENOVATIONOFPREMISSES:
                HMSUtils.doSmth(welderVanya);
        }

        switch (dryOfHall.getType()) {
            case CLEANING:
                LOGGER.info("Worker do cleaning");
                HMSUtils.doSmth(iDo1);
                break;
            case GARBAGEREMOVAL:
                LOGGER.info("Worker move and lok after the process");
                HMSUtils.move(iMove2);
                break;
            case REPAIRINOUTLETPIPES:
                HMSUtils.doSmth(piperVasia);
                break;
            case REPAIRINOUTLETWIRES:
                HMSUtils.move(welderKolya);
                break;
            case RENOVATIONOFPREMISSES:
                HMSUtils.doSmth(welderVanya);
        }

        ClassLoader classLoader = TheClassName.class.getClassLoader();
        File fileName = new File(Objects.requireNonNull(classLoader.getResource("Mockingjay.txt")).getFile());
        List<String> allWords = readTxtFile(fileName);
        countSortDuplicate(allWords);

        Truck truck1 = new Truck("TGL", "MAN", Vehicle.WheelsCount.ONE);
        Truck truck2 = new Truck("2705", "KAMAZ", Vehicle.WheelsCount.FOUR);
        switch (truck1.getWheelsCount()) {
            case ONE:
            case TWO:
            case THREE:
                LOGGER.info("Truck 1 is broken");
                break;
            case FOUR:
                LOGGER.info("Truck 1 is worked right");
                break;
        }
        if (!(truck2.getWheelsCount().getCount() == 4)) {
            LOGGER.info("Truck 2 is broken");
        } else LOGGER.info("Truck 2 is worked right");

        try {
            Class<Child> childClass = (Class<Child>) Class.forName("com.solvd.hms.base.Child");
            Constructor<Child> childConstructor = childClass.getDeclaredConstructor(String.class, String.class, LocalDate.class);
            Child child4 = childConstructor.newInstance("Danya", "Lapin", LocalDate.of(2014, 8, 12));
            Method childMethod = childClass.getDeclaredMethod("say");
            Object methodResult = childMethod.invoke(child4);
            Field childField1 = childClass.getDeclaredField("infantAge");
            Object typeField1 = childField1.getGenericType();
            Boolean field2 = childField1.equals(8);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        IRun run = () -> LOGGER.info("use the functional interface");
        ICount count = (t, u) -> {
            double s = t / u;
            LOGGER.info("after divide return " + s);
        };
        IWait wait = (w) -> LOGGER.info("I'm waiting " + w + " minutes");

        run.run();
        count.count(555.34, 3);
        wait.wait1(7);

        Runnable workerDo = () -> LOGGER.info("try to use build-in functional interfaces");
        Consumer<String> sayer = saySmth -> LOGGER.info("Client say " + saySmth);
        Supplier<Integer> randomGeter = () -> {
            int value = (int) (Math.random() * 17);
            return value;
        };
        Function<String, Integer> dataChanger = Integer::valueOf;
        Predicate<Integer> isEvenNumber = x -> (x % 2 == 0);
        BiConsumer<String, String> greeter = (firstName, lastName) -> LOGGER.info("Hello " + firstName + " " + lastName);
        BiFunction<String, String, String> namer = (firstName, lastName) -> firstName + " " + lastName;

        workerDo.run();
        sayer.accept("Thanks a lot!");
        LOGGER.info("Random number = " + randomGeter.get());
        LOGGER.info("Change data type: " + dataChanger.apply("10000"));
        LOGGER.info(isEvenNumber.test(10));
        LOGGER.info(isEvenNumber.test(5));
        greeter.accept(welderKolya.getFirstName(), welderKolya.getLastName());
        LOGGER.info(namer.apply(cleanerPetya.getFirstName(), cleanerPetya.getLastName()));

        try (HMS partizanskiHMS = new HMS("PartizanskiHMS", 34, new Address("Rumyanceva", 37, 2), addresses, services)) {
            orders.stream()
                    .filter(order -> HMSUtils.checkService(order, partizanskiHMS) == 1)
                    .map(Order::getId).forEach(t -> LOGGER.info(t + "  number of orders can be done"));
            orders.stream()
                    .filter(order -> HMSUtils.checkService(order, partizanskiHMS) == 0)
                    .map(Order::getId).forEach(t -> LOGGER.info(t + "  number of orders can't be done"));
        }
    }
}



