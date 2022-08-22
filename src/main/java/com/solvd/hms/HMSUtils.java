package com.solvd.hms;

import com.solvd.hms.base.*;
import com.solvd.hms.order.Order;
import com.solvd.hms.organization.HMS;
import com.solvd.hms.resources.Worker;
import com.solvd.hms.service.Service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

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

    public static void readTxtFile(String fileName) {
        try {
//            FileReader tfr = new FileReader(fileName);
//            char[] buffer = new char[8096];
//            int chars = tfr.read(buffer);
//            while (chars != -1) {
//                System.out.println(String.valueOf(buffer, 0, chars));
//                chars = tfr.read(buffer);
//            }
//            tfr.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileReader fr1 = new FileReader(fileName);
            String name;
            int c;
            char[] buffer = new char[8096];
            System.out.println("Print File Files.txt? y/n");
            name = br.readLine();
            if(name.equals("y"))
            while ((c = fr1.read(buffer)) != -1) {
                buffer = Arrays.copyOf(buffer, c);
            }
            String myString = new String (buffer);
            System.out.println((myString));
//            Arrays.toString(myString.split(" "));

            fr1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}