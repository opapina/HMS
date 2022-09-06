package com.solvd.hms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static ConnectionPool INSTANCE;
    private List<Connection> connections = new ArrayList<>();
    private List<Connection> usedConnections = new ArrayList<>();
    private Integer maxConnection;

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConnectionPool();
        }
        return INSTANCE;
    }

    public static synchronized List<Connection> getConnection(Integer maxConnection) {
        List<Connection> connections = new ArrayList<>(maxConnection );
        for (int i = 0; i < maxConnection; i++) {
            Connection con = new Connection();
            LOGGER.info("successfully connected - " + con.getUrl() + " username: " + con.getUsername());
            connections.add(con);
        }

//        Connection con = connectionPool.remove(connectionPool.size() - 1);
//        usedConnections.add(connection);
//        return connection;
////        if (connections.size() == 0) return null;
//        connections.remove(connections.size() - 1);
        return connections;
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
