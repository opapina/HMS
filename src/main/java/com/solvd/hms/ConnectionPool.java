package com.solvd.hms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static ConnectionPool INSTANCE;

    public ConnectionPool() {
    }

    private List<Connection> connections = new ArrayList<>();

    public static ConnectionPool getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConnectionPool();
        }
        return INSTANCE;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    public synchronized Connection getConnection() {
//        if (connections.size() == 0) return null;
        Connection connection = connections.remove(connections.size() - 1);
        LOGGER.info("successfully connected - " + connection.getUrl() + " username: " + connection.getUsername());
        return connection;
    }

    public void releaseConnection(Connection connection) {
        connections.add(connection);
        LOGGER.info("close connection - " + connection.getUrl());
        connection = null;
    }

    public boolean isNotEmpty() {
        return this.connections.size() > 0;
    }

    public int getSize() {
        return this.connections.size();
    }
}
