package com.solvd.hms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static ConnectionPool INSTANCE;
    private static List<Connection> connections;

    private ConnectionPool(Integer maxConnection) {
        BlockingQueue<Connection> connections = new ArrayBlockingQueue<>(maxConnection);
        for(int i = 0; i < maxConnection; i++) {
            Connection con = new Connection();
            connections.add(con);
            }
    }

    public static ConnectionPool getInstance(Integer maxConnection) {
        if (INSTANCE == null) {
            INSTANCE = new ConnectionPool(maxConnection);
        }
        return INSTANCE;
    }

    public synchronized Connection getConnection() {
        queue.put(connection);
        Connection connection = connections.remove(connections.size() - 1);
        LOGGER.info("successfully connected - " + connection.getUrl() + " username: " + connection.getUsername());
        return connection;
    }

    public void releaseConnection(Connection connection) throws InterruptedException {
        connections.add(connection);
        LOGGER.info("close connection - " + connection.getUrl());
    }

    public static boolean isNotEmpty() {
        return connections.size() > 0;
    }
}
