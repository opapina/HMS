package com.solvd.hms;

import com.solvd.hms.base.*;
import com.solvd.hms.order.Order;
import com.solvd.hms.organization.HMS;
import com.solvd.hms.resources.Worker;
import com.solvd.hms.service.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HMSUtils {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static int checkService(Order<?> order, HMS hms) {
        List<Address> addresses = hms.getAddresses();
        List<Service> services = hms.getServices();

        Optional<Address> street = addresses.stream()
                .filter(address -> address.getStreet().equals(order.getStreet()))
                .findFirst();

        Optional<Service> serviceOr =services.stream()
                .filter(service -> service.type.equals(order.getServiceName()))
                .findFirst();

        if (!street.isPresent() && !serviceOr.isEmpty()) {
            return 1;}
        else { return 0;}
    }

    public static void communicate(Human human) {
        if (human.getClass().equals(Worker.class)) {
            human.ask();
        } else {
            human.say();
        }
    }

    public static void ask(IAsk iAsk) {
        iAsk.askHelp();
    }

    public static void doSmth(IDo iDo) {
        iDo.doOrder();
        iDo.tellOfOrder();
    }

    public static void move(IMove iMove) {
        iMove.go();
        iMove.dance();
    }

    public static void work(IWork iWork) {
        iWork.think();
        iWork.operate();
    }

    public static List<String> readTxtFile(File fileName) throws IOException {
        List<String> lines = FileUtils.readLines(fileName, StandardCharsets.UTF_8);
        String words = lines.stream().map(Object::toString).reduce("", String::concat);
        List<String> allWords = List.of(StringUtils.split(words, "[ ,\"?:\\.]"));
        return allWords;
    }

    public static void countSortDuplicate(List<String> words) throws IOException {
        Map<Object, Long > mapWords = words.stream()
                .filter(w -> (Collections.frequency(words, w) > 1))
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        int duplicateCount = words.size() -mapWords.size();
        LOGGER.info("count of duplicate words " + duplicateCount);

        List<Map.Entry<Object, Long>> entries = new ArrayList<>(mapWords.entrySet());
        entries.sort(new Comparator<Map.Entry<Object, Long>>() {
            public int compare(Map.Entry<Object, Long> a, Map.Entry<Object, Long> b) {
                return Long.compare(b.getValue(), a.getValue());
            }
        });

        try {
            for(Map.Entry<Object, Long> e : entries) {
                File writer = new File("sortedDuplicate.txt");
                FileUtils.writeLines(writer, entries, false);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
