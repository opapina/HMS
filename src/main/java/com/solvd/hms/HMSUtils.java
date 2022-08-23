package com.solvd.hms;

import com.solvd.hms.base.*;
import com.solvd.hms.order.Order;
import com.solvd.hms.organization.HMS;
import com.solvd.hms.resources.Worker;
import com.solvd.hms.service.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class HMSUtils {

    public static int checkService(Order<?> orders1, HMS hms) {
        boolean streetAvailable = Boolean.FALSE;
        boolean serviceAvailable = Boolean.FALSE;
        List<Address> addresses = hms.getAddresses();
        List<Service> services = hms.getServices();

        for (Address value : addresses) {
            if (value.getStreet().equals(orders1.getStreet())) {
                continue;
            }
            streetAvailable = Boolean.TRUE;
        }

        if (!streetAvailable) {
            return 0;
        }

        for (Service service : services) {
            if (service.type.equals(orders1.getServiceName())) {
                serviceAvailable = Boolean.TRUE;
                break;
            }
        }
        if (!serviceAvailable) {
            return 0;
        }
        return 1;
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

    public static List<String> readTxtFile(Path fileName) {
        List<String> allWords = null;
        try {
            List<String> lines = Files.readAllLines(fileName, StandardCharsets.UTF_8);
            allWords = new ArrayList<>();
            for (String line : lines) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.length() > 0) {
                        allWords.add(word);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return allWords;
    }

    public static void countSortDuplicate(List<String> words) {
        HashMap<String, Integer> mapWords = new HashMap<>();
        Set<String> uniqueWords = new HashSet<>(words);
        int count1 = 0;
        for (String word : uniqueWords) {
            int count = Collections.frequency(words, word);
            if (count > 1) {
                mapWords.put(word, count);
            } else count1++;
        }
        int duplicateCount = words.size() - uniqueWords.size();
        System.out.println(duplicateCount);

        mapWords.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);

//            try (FileWriter writer = new FileWriter("sortedDuplicate.txt", false)) {
//                // запись всей строки
//                String text = mapWords.toString();
//                writer.write(text);
//                // запись по символам
//                writer.append('\n');
//                writer.append('E');
//
//                writer.flush();
//            } catch (IOException ex) {
//
//                System.out.println(ex.getMessage());
//            }
//        }

    }
}
