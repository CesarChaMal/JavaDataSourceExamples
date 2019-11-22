package com.mkyong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample {

    public static void main(String[] args) {

        // https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html#package.description
        // auto java.sql.Driver discovery -- no longer need to load a java.sql.Driver class via Class.forName

        // register JDBC driver, optional since java 1.6
        /*try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        // auto close connection
//        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "postgres")) {
//        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rtdms", "dmsirc0115", "PWDDMSIRC0115")) {
//        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://10.230.142.195:5432/rtdms", "dmsirc0115", "PWDDMSIRC0115")) {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://frlyonl0221.srv.volvo.com:5432/rtdms", "postgres", "postgres")) {

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}