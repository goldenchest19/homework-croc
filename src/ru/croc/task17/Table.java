package ru.croc.task17;

import java.sql.*;
import java.util.HashSet;
import java.util.List;

public class Table {
    private static final String connectionUrl = "jdbc:h2:/home/kirill/h2/db/test";
    private static final String user = "sa";
    private static final String password = "sa";
    private static final String SQL_INSERT_PRODUCTS = "INSERT INTO PRODUCTS (ARCTICLE, TITLE, PRICE) VALUES (?,?,?)";
    private static final String SQL_INSERT_ORDERS = "INSERT INTO ORDERS (ID, NAME, ARCTICLE_PRODUCTS) VALUES (?,?,?)";


    public Table(List<List<String>> list, HashSet<List<String>> uniqueProducts) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        new org.h2.Driver();
        createTableProducts();
        createTableOrders();
        insertTableProducts(uniqueProducts);
        insertTableOrders(list);
    }


    private static void insertTableProducts(HashSet<List<String>> hashSet) throws SQLException {

        try (Connection connection = DriverManager.getConnection(connectionUrl, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_PRODUCTS)) {
            for (List<String> list : hashSet) {

                preparedStatement.setString(1, list.get(0));
                preparedStatement.setString(2, list.get(1));
                String price = list.get(2).strip();
                preparedStatement.setInt(3, Integer.parseInt(price));

                preparedStatement.executeUpdate();
            }
        }
    }


    private static void insertTableOrders(List<List<String>> list) throws SQLException {

        try (Connection connection = DriverManager.getConnection(connectionUrl, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_ORDERS)) {

            for (List<String> stringList : list) {
                String ID = stringList.get(0).strip();
                preparedStatement.setInt(1, Integer.parseInt(ID));
                preparedStatement.setString(2, stringList.get(1));
                preparedStatement.setString(3, stringList.get(2));

                preparedStatement.executeUpdate();
            }
        }
    }


    private static void createTableProducts() throws SQLException {

        try (Connection connection = DriverManager.getConnection(connectionUrl, user, password);
             Statement stmt = connection.createStatement()) {
            String sql = "CREATE TABLE products " +
                    " (arcticle VARCHAR(25) PRIMARY KEY NOT NULL UNIQUE , " +
                    " title VARCHAR(100) , " +
                    " price INTEGER) ";

            stmt.executeUpdate(sql);
        }
    }


    private static void createTableOrders() throws SQLException {

        try (Connection connection = DriverManager.getConnection(connectionUrl, user, password);
             Statement stmt = connection.createStatement()) {
            String sql = "CREATE TABLE orders " +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(50) NOT NULL, " +
                    " arcticle_products VARCHAR(25) NOT NULL," +
                    "FOREIGN KEY (arcticle_products) REFERENCES PRODUCTS (arcticle) ON DELETE CASCADE )";

            stmt.executeUpdate(sql);
        }
    }
}
