package com.solvd.hms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static ConnectionPool INSTANCE;
    private static List<Connection> connections;
    private static List<Connection> usedConnections = new ArrayList<>();
    private Integer maxConnection;

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ConnectionPool();
        }
        return INSTANCE;
    }

    public static synchronized Connection getConnection(Integer maxConnection) throws InterruptedException {
        List<Connection> connections = new ArrayList<>(maxConnection );
        for(int i = 0; i < maxConnection; i++) {
            Connection con = new Connection();
            LOGGER.info("successfully connected - " + con.getUrl() + " username: " + con.getUsername());
            connections.add(con);
        }
        if ((connections.size() == 0)) Thread.sleep(4000);
        Connection connection = connections.remove(connections.size() - 1);
        List<Connection> usedConnections = new ArrayList<>();
        usedConnections.add(connection);
        return connection;
    }

    public static void releaseConnection(Connection connection) throws InterruptedException {
        if ((connections.size() == 0)) Thread.sleep(4000);
        connections.add(connection);
        LOGGER.info("close connection - " + connection.getUrl());
        usedConnections.remove(connection);
    }

    public boolean isNotEmpty() {
        return this.connections.size() > 0;
    }

    public int getSize() {
        return this.connections.size();
    }
}
