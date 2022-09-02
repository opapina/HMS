package com.solvd.hms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static ConnectionPool INSTANCE;
    private List<Connection> connections = new ArrayList<>();

    public ConnectionPool (int maxPoolSize) {
    }

    public static ConnectionPool getInstance(int maxPoolSize) {
        if (INSTANCE==null) {
            INSTANCE = new ConnectionPool(maxPoolSize);
        }
        return INSTANCE;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    public synchronized Connection getConnection() {
        Connection connection = connections.remove(connections.size() - 1);
        LOGGER.info("successfully connection - " + connection.getUrl() +" username: " + connection.getUsername());
        return connection;
    }

    public void releaseConnection(Connection connection) {
        connections.add(connection);
        LOGGER.info("close connection - " + connection.getUrl());
        connection = null;
    }
}
