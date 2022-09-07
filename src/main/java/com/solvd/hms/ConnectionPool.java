package com.solvd.hms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static ConnectionPool INSTANCE;
    private static List<Connection> connections;
    private static List<Connection> usedConnections = Collections.synchronizedList(new ArrayList<Connection>());
    private Integer maxConnection;

    private ConnectionPool(Integer maxConnection) {
        this.maxConnection = maxConnection;
        this.connections  = Collections.synchronizedList(new ArrayList<Connection>(maxConnection));
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

    public static synchronized Connection getConnection() {
        Connection connection = connections.remove(connections.size() - 1);
        List<Connection> usedConnections = new ArrayList<>();
        usedConnections.add(connection);
        LOGGER.info("successfully connected - " + connection.getUrl() + " username: " + connection.getUsername());
        return connection;
    }

    public static void releaseConnection(Connection connection) throws InterruptedException {
        connections.add(connection);
        LOGGER.info("close connection - " + connection.getUrl());
        usedConnections.remove(connection);
    }

    public static boolean isNotEmpty() {
        return connections.size() > 0;
    }

    public static int getSize() {
        return connections.size();
    }
}
