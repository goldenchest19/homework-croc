package ru.croc.task18;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;

import java.sql.*;
import java.util.List;

public class WorkWithProduct {

    private static final String connectionUrl = "jdbc:h2:/home/kirill/h2/db/test";
    private static final String user = "sa";
    private static final String password = "sa";
    private static final String SQL_INSERT_PRODUCTS = "INSERT INTO PRODUCTS (ARCTICLE, TITLE, PRICE) VALUES (?,?,?)";

    public static Product findProduct(String productCode) throws ClassNotFoundException, SQLException {
        Product product = new Product();

        Class.forName("org.h2.Driver");

        // open connection as an auto-closeable resource
        try (Connection connection = DriverManager
                .getConnection(connectionUrl, user, password)) {

            // create and run statement
            String sql = "select * from PRODUCTS where ARCTICLE = ?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, productCode);
                try (ResultSet result = statement.executeQuery()) {
                    while (result.next()) {
                        product.setArticle(result.getString("ARCTICLE"));
                        product.setTitle(result.getString("TITLE"));
                        product.setPrice(result.getInt("PRICE"));
                        return product;
                    }
                }
            }
        }
        return null;
    }

    public static Product createProduct(Product product) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");

        try (Connection connection = DriverManager
                .getConnection(connectionUrl, user, password)) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement(SQL_INSERT_PRODUCTS)) {

                preparedStatement.setString(1, product.getArticle());
                preparedStatement.setString(2, product.getTitle());
                preparedStatement.setInt(3, product.getPrice());

                preparedStatement.executeUpdate();
                return product;
            } catch (JdbcSQLIntegrityConstraintViolationException exception) {
                System.err.println("Товар с данным артиклем уже создан");
            }
        }
        return null;
    }

    public static Product updateProduct(Product product) throws SQLException, ClassNotFoundException {
        String article = product.getArticle();

        if (findProduct(article) == null) {
            System.out.println("Данного товара не существует");
            return null;
        }

        Class.forName("org.h2.Driver");

        // open connection as an auto-closeable resource
        try (Connection connection = DriverManager
                .getConnection(connectionUrl, user, password)) {

            String sql =
                    String.format("UPDATE PRODUCTS SET TITLE = ?, PRICE = ? WHERE ARCTICLE = '%s'", article);

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, product.getTitle());
                statement.setInt(2, product.getPrice());
                statement.executeUpdate();
                return product;
            }
        }
    }

    public static void deleteProduct(String productCode) throws ClassNotFoundException, SQLException {

        if (findProduct(productCode) == null) {
            System.out.println("Товар не удален, так как данного товара не существует");
            return;
        }

        Class.forName("org.h2.Driver");
        String sql =
                String.format("DELETE FROM PRODUCTS WHERE ARCTICLE = '%s'", productCode);

        try (Connection connection = DriverManager
                .getConnection(connectionUrl, user, password)) {
            try (Statement statement =
                         connection.createStatement()) {

                statement.executeUpdate(sql);
            }
        }
    }
}
