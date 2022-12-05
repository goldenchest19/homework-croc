package ru.croc.task17;

import java.sql.*;
import java.util.HashSet;
import java.util.List;

public class Table {
    private static final String connectionUrl = "jdbc:h2:/home/kirill/h2/db/test";
    private static final String user = "sa";
    private static final String password = "sa";

    private static final String SQL_INSERT_PRODUCTS = "INSERT INTO PRODUCTS (ARCTICLE, TITLE, PRICE) VALUES (?,?,?)";


    public static void addDataToDB(List<List<String>> list) throws SQLException, ClassNotFoundException {
//        createTableProducts();
//        createTableOrders();
//        test();
        insertTableProducts();
//        testProd();
    }

    private static void testProd() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");

        // open connection as an auto-closeable resource
        try (Connection connection = DriverManager
                .getConnection(connectionUrl, user, password)) {

            // create and run statement
            String sql = "SELECT * FROM PRODUCTS";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);

                // print result set to stdout
                printResultSet(resultSet);
            }
        }

    }

    private static void insertTableProducts(HashSet<List<String>> hashSet) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");

        try (Connection connection = DriverManager
                .getConnection(connectionUrl, user, password)) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_PRODUCTS)){

                for (List<String> list : hashSet) {

                    for (int i = 0; i < list.size(); i++) {

                    }
                }

                preparedStatement.setString(1, "T1");
                preparedStatement.setString(2, "Монитор");
                preparedStatement.setInt(3, 500);

                int row = preparedStatement.executeUpdate();
                System.out.println(row);
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
//                    "(id INTEGER not NULL, " +
                    " (arcticle VARCHAR(25) NOT NULL UNIQUE , " +
                    " title VARCHAR(100) UNIQUE , " +
                    " price INTEGER UNIQUE) ";
//                    " PRIMARY KEY ( id ))";
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
