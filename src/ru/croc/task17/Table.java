package ru.croc.task17;

import java.sql.*;
import java.util.List;

public class Table {
    private static final String connectionUrl = "jdbc:h2:/home/kirill/h2/db/test";
    private static final String user = "sa";
    private static final String password = "sa";

    public static void addDataToDB(List<List<String>> list) throws SQLException, ClassNotFoundException {
//        createTableProducts();
//        createTableOrders();
//        test();
        insertTableProducts();
    }

    private static void insertTableProducts() throws ClassNotFoundException, SQLException {

        Statement stmt = null;
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection(connectionUrl, user, password);
            Class.forName("org.h2.Driver");
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + " " + rs.getString("ARTICLE"));
            }
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
                    "(id INTEGER not NULL, " +
                    " arcticle VARCHAR(25) NOT NULL, " +
                    " title VARCHAR(100), " +
                    " price INTEGER, " +
                    " PRIMARY KEY ( id ))";
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
        }  finally {
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

//    private static void test() throws ClassNotFoundException, SQLException {
//        //STEP 2: Register JDBC driver
//        Connection conn = null;
//        Statement stmt = null;
//
//        String connectionUrl = "jdbc:h2:/home/kirill/h2/db/test";
//        String user = "sa";
//        String password = "sa";
//        try {
//            Class.forName("org.h2.Driver");
//
//
//            //STEP 3: Open a connection
//            System.out.println("Connecting to a selected database...");
//            conn = DriverManager.getConnection(connectionUrl, user, password);
//            System.out.println("Connected database successfully...");
//
//            //STEP 4: Execute a query
//            System.out.println("Creating table in given database...");
//            stmt = conn.createStatement();
//
//            String sql = "CREATE TABLE REGISTRATION " +
//                    "(id INTEGER not NULL, " +
//                    " first VARCHAR(255), " +
//                    " last VARCHAR(255), " +
//                    " age INTEGER, " +
//                    " PRIMARY KEY ( id ))";
//
//            stmt.executeUpdate(sql);
//            System.out.println("Created table in given database...");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    private static void creatTableProducts() throws ClassNotFoundException, SQLException {
//        Class.forName("org.h2.Driver");
//
//        Statement stmt;
//        try (Connection connection = DriverManager
//                .getConnection(connectionUrl, user, password)) {
//            stmt = connection.createStatement();
//            String sql = "CREATE TABLE products " +
//                    "(id INTEGER not NULL, " +
//                    " arcticle VARCHAR(25) NOT NULL, " +
//                    " title VARCHAR(100), " +
//                    " price INTEGER, " +
//                    " PRIMARY KEY ( id ))";
//            stmt.executeUpdate(sql);
//        }
//    }
//
//    private static void createTableOrders() throws ClassNotFoundException, SQLException {
//        Class.forName("org.h2.Driver");
//
//        Statement stmt;
//        try (Connection connection = DriverManager
//                .getConnection(connectionUrl, user, password)) {
//            stmt = connection.createStatement();
//            String sql = "CREATE TABLE orders " +
//                    "(id INTEGER not NULL, " +
//                    " name VARCHAR(50) NOT NULL, " +
//                    " arcticle_products VARCHAR(25) NOT NULL)";
//            stmt.executeUpdate(sql);
//        }
//    }
//
//    private static void test() throws ClassNotFoundException, SQLException {
//        //STEP 2: Register JDBC driver
//        Connection conn = null;
//        Statement stmt = null;
//
//        String connectionUrl = "jdbc:h2:/home/kirill/h2/db/test";
//        String user = "sa";
//        String password = "sa";
//        try {
//            Class.forName("org.h2.Driver");
//
//
//            //STEP 3: Open a connection
//            System.out.println("Connecting to a selected database...");
//            conn = DriverManager.getConnection(connectionUrl, user, password);
//            System.out.println("Connected database successfully...");
//
//            //STEP 4: Execute a query
//            System.out.println("Creating table in given database...");
//            stmt = conn.createStatement();
//
//            String sql = "CREATE TABLE REGISTRATION " +
//                    "(id INTEGER not NULL, " +
//                    " first VARCHAR(255), " +
//                    " last VARCHAR(255), " +
//                    " age INTEGER, " +
//                    " PRIMARY KEY ( id ))";
//
//            stmt.executeUpdate(sql);
//            System.out.println("Created table in given database...");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public static void createTable() throws SQLException, ClassNotFoundException {
//        // load JDBC driver class
//        Class.forName("org.h2.Driver");
//
//        Statement stmt;
//        // open connection as an auto-closeable resource
//        try (Connection connection = DriverManager
//                .getConnection(connectionUrl, user, password)) {
//            stmt = connection.createStatement();
//            // create and run statement
////            String sql = "SELECT * FROM Sign s JOIN Figure f ON s.figure = f.id";
//            String sql = "CREATE TABLE REGISTRATION " +
//                    "(id INTEGER not NULL, " +
//                    " first VARCHAR(255), " +
//                    " last VARCHAR(255), " +
//                    " age INTEGER, " +
//                    " PRIMARY KEY ( id ))";
//            stmt.executeUpdate(sql);
//        }
//    }
}
