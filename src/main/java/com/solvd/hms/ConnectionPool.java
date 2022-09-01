package com.solvd.hms;

import java.util.List;

public class ConnectionPool {

    private static ConnectionPool INSTANCE;
    private List<Connection> connections;

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        if (INSTANCE==null) {
            INSTANCE = new ConnectionPool();
        }
        return INSTANCE;
    }

    public synchronized Connection getConnection(Connection currentConnection) {
        System.out.println("successfully connected " + currentConnection.getUrl());
        return currentConnection;
    }
    public void releaseConnection(Connection connection) {
        System.out.println("Connection" + connection.getUrl() + " released");
    }
}
