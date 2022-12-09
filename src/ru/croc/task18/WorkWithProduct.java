package ru.croc.task18;

import java.sql.*;

public class WorkWithProduct {

    private static final String connectionUrl = "jdbc:h2:/home/kirill/h2/db/test";
    private static final String user = "sa";
    private static final String password = "sa";
    private static final String SQL_INSERT_PRODUCTS = "INSERT INTO PRODUCTS (ARCTICLE, TITLE, PRICE) VALUES (?,?,?)";

    public WorkWithProduct() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
    }

    public static Product findProduct(String productCode) throws SQLException {
        Product product = new Product();
        String sql = "select * from PRODUCTS where ARCTICLE = ?";

        try (Connection connection = DriverManager.getConnection(connectionUrl, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, productCode);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    product.setArticle(result.getString("ARCTICLE"));
                    product.setTitle(result.getString("TITLE"));
                    product.setPrice(result.getInt("PRICE"));
                    return product;
                }
            }
        }
        return null;
    }

    public static Product createProduct(Product product) throws SQLException {

        if (findProduct(product.getArticle()) != null) {
            throw new RuntimeException("Товар с данным артиклем уже существует");
        }


        try (Connection connection = DriverManager
                .getConnection(connectionUrl, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_PRODUCTS)) {

            preparedStatement.setString(1, product.getArticle());
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setInt(3, product.getPrice());

            preparedStatement.executeUpdate();
            return product;
        }
    }

    public static Product updateProduct(Product product) throws SQLException {
        String article = product.getArticle();
        String sql =
                String.format("UPDATE PRODUCTS SET TITLE = ?, PRICE = ? WHERE ARCTICLE = '%s'", article);

        if (findProduct(article) == null) {
            System.out.println("Товара с таким артиклем не существует, не удалось обновить данные");
            return null;
        }

        try (Connection connection = DriverManager.getConnection(connectionUrl, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getTitle());
            statement.setInt(2, product.getPrice());
            statement.executeUpdate();
            return product;
        }
    }

    public static void deleteProduct(String productCode) throws SQLException {

        if (findProduct(productCode) == null) {
            System.out.println("Товар не удален, так как данного товара не существует");
            return;
        }

        String sql =
                String.format("DELETE FROM PRODUCTS WHERE ARCTICLE = '%s'", productCode);

        try (Connection connection = DriverManager
                .getConnection(connectionUrl, user, password);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(sql);
        }
    }
}
