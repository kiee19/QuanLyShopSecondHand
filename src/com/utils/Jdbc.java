package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {

    static String url = "jdbc:sqlserver://localhost:1433;databaseName=SecondHandShop";
    static String user = "sa";
    static String pass = "Password.1";
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static Connection conn;

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        conn = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmt;
        if (sql.trim().startsWith("{")) {
            stmt = conn.prepareCall(sql); //Proc
        } else {
            stmt = conn.prepareStatement(sql); // SQL
        }
        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i + 1, args[i]);
        }
        return stmt;
    }

    public static ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement stmt = Jdbc.getStmt(sql, args);
        return stmt.executeQuery();
    }

    public static Object value(String sql, Object... args) throws SQLException {
        try {
            ResultSet rs = Jdbc.query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;

        } catch (SQLException e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        }
    }

    public static void update(String sql, Object... args) throws SQLException {
        try {
            PreparedStatement stmt = Jdbc.getStmt(sql, args);
            try {
                stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }

        } catch (SQLException e) {
            // TODO: handle exception
            throw new RuntimeException(e);
        }
    }
}
