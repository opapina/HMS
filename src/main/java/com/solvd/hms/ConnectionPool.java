package com.solvd.hms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static ConnectionPool INSTANCE;
    private static BlockingQueue<Connection> connections;

    private ConnectionPool(Integer maxConnection) {
        connections = new ArrayBlockingQueue<>(maxConnection);
        for (int i = 0; i < maxConnection; i++) {
            Connection con = new Connection();
            try {
                connections.put(con);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static ConnectionPool getInstance(Integer maxConnection) {
        if (INSTANCE == null) {
            INSTANCE = new ConnectionPool(maxConnection);
        }
        return INSTANCE;
    }

    public synchronized Connection getConnection() {
        try {
            Connection connection = connections.take();
            LOGGER.info("successfully connected - " + connection.getUrl() + " username: " + connection.getUsername());
            return connection;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void releaseConnection(Connection connection) {
        try {
            connections.put(connection);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("close connection - " + connection.getUrl());
    }
}
