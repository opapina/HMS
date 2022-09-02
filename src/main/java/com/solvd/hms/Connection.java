package com.solvd.hms;

public class Connection {

    private String url;
    private String username;
    private String password;

    private final int delayTime;

    public Connection(String url, String username, String password, int delayTime) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.delayTime = delayTime;
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

    public int getDelayTime() {
        return delayTime;
    }

    public void printData() {
        System.out.println("info from " + this.getUrl() + "  before");
        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("info from " + this.getUrl() + "  after");
    }

    public void inputData() {
        try {
            System.out.println("Input data on the " + this.getUrl() + "  page");
            Thread.sleep(delayTime + 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void readData() {
        try {
            System.out.println("Read data on the " + this.getUrl() + "  page");
            Thread.sleep(delayTime + 1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
