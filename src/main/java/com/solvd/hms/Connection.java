package com.solvd.hms;

import java.sql.SQLException;

public class Connection {
    private static Connection ds = new Connection();

    static {
        ds.setUsername("user");
        ds.setPassword("password");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    private void setUsername(String user) {
    }

    private void setPassword(String password) {

    }

    private void setMaxOpenPreparedStatements(int i) {
    }

    private void setMaxIdle(int i) {

    }

    private void setMinIdle(int i) {

    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private Connection(){ }
}
