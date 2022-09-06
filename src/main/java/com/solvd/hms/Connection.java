package com.solvd.hms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.SecureRandom;

public class Connection {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private String url;
    private String username;
    private String password;

    public Connection() {
        this.url = wordRandom();
        this.username = wordRandom();
        this.password = wordRandom();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void printData() {
        LOGGER.info("Start print data from " + this.getUrl());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("Finish print data from  " + this.getUrl());
    }

    public void inputData() {
        try {
            LOGGER.info("Input data on the page  " + this.getUrl());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void readData() {
        try {
            LOGGER.info("Read data on the page  " + this.getUrl());
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static String wordRandom() {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }
}
