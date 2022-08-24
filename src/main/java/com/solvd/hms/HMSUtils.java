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

public class HMSUtils {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

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

    public static List<String> readTxtFile(File fileName) {
        List<String> allWords = null;
        try {
            List<String> lines = FileUtils.readLines(fileName, StandardCharsets.UTF_8);
            allWords = new ArrayList<>();
            for (String line : lines) {
                String[] words = StringUtils.split(line, "[ ,?:\\.]");
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

    public static <e> void countSortDuplicate(List<String> words) throws IOException {
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
        LOGGER.info("count of duplicate words " + duplicateCount);

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(mapWords.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return Integer.compare(b.getValue(), a.getValue());
            }
        });

        try {
            for(Map.Entry<String, Integer> e : entries) {
                File writer = new File("sortedDuplicate.txt");
                FileUtils.write(writer, e.getKey() + " " + e.getValue() + "\n", true);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }
}