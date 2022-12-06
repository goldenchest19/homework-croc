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

    // управляющий метод
    public static void addDataToDB(List<List<String>> list, HashSet<List<String>> hashSet) throws SQLException, ClassNotFoundException {
        createTableProducts();
        createTableOrders();
        insertTableProducts(hashSet);
        printDBProducts();
        insertTableOrders(list);
        printDBOrders();
    }

    /**
     * Метод, который выводит данные из таблицы Products
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private static void printDBProducts() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");

        try (Connection connection = DriverManager
                .getConnection(connectionUrl, user, password)) {

            String sql = "SELECT * FROM PRODUCTS";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);

                printResultSet(resultSet);
            }
        }
    }

    /**
     * Метод, который выводит данные из таблицы Orders
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private static void printDBOrders() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");

        // open connection as an auto-closeable resource
        try (Connection connection = DriverManager
                .getConnection(connectionUrl, user, password)) {

            // create and run statement
            String sql = "SELECT * FROM ORDERS";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);

                // print result set to stdout
                printResultSet(resultSet);
            }
        }
    }

    /**
     * вставка данных в таблицу из hashset
     *
     * @param hashSet
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private static void insertTableProducts(HashSet<List<String>> hashSet) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");

        try (Connection connection = DriverManager
                .getConnection(connectionUrl, user, password)) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement(SQL_INSERT_PRODUCTS)) {
                for (List<String> list : hashSet) {

                    preparedStatement.setString(1, list.get(0));
                    preparedStatement.setString(2, list.get(1));
                    String price = list.get(2).strip();
                    preparedStatement.setInt(3, Integer.parseInt(price));

                    preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %sn%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertTableOrders(List<List<String>> list) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");

        try (Connection connection = DriverManager
                .getConnection(connectionUrl, user, password)) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement(SQL_INSERT_ORDERS)) {

                for (List<String> stringList : list) {
                    String ID = stringList.get(0).strip();
                    preparedStatement.setInt(1, Integer.parseInt(ID));
                    preparedStatement.setString(2, stringList.get(1));
                    preparedStatement.setString(3, stringList.get(2));

                    preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %sn%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData meta = resultSet.getMetaData();
        int numColumns = meta.getColumnCount();
        for (int i = 0; i < numColumns; i++) {
            if (i > 0)
                System.out.print(", ");
            System.out.print(meta.getColumnName(i + 1));
        }
        System.out.println();
        System.out.println("---");
        while (resultSet.next()) {
            for (int i = 0; i < numColumns; i++) {
                if (i > 0)
                    System.out.print(", ");
                System.out.print(resultSet.getString(i + 1));
            }
            System.out.println();
        }
    }


    private static void createTableProducts() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection = null;
        Statement stmt = null;
        try {
            connection = DriverManager
                    .getConnection(connectionUrl, user, password);
            stmt = connection.createStatement();
            String sql = "CREATE TABLE products " +
                    " (arcticle VARCHAR(25) NOT NULL UNIQUE , " +
                    " title VARCHAR(100) , " +
                    " price INTEGER) ";
            stmt.executeUpdate(sql);
        } finally {
            try {
                if (stmt != null)
                    connection.close();
            } catch (SQLException se) {
            } try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private static void createTableOrders() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection = null;
        Statement stmt = null;

        try {
            connection = DriverManager
                    .getConnection(connectionUrl, user, password);
            stmt = connection.createStatement();
            String sql = "CREATE TABLE orders " +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(50) NOT NULL, " +
                    " arcticle_products VARCHAR(25) NOT NULL)";
            stmt.executeUpdate(sql);
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    connection.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
