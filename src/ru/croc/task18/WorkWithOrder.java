package ru.croc.task18;

import java.sql.*;
import java.util.List;

public class WorkWithOrder {
    private static final String connectionUrl = "jdbc:h2:/home/kirill/h2/db/test";
    private static final String user = "sa";
    private static final String password = "sa";
    private static final String SQL_INSERT_ORDERS = "INSERT INTO ORDERS (ID, NAME, ARCTICLE_PRODUCTS) VALUES (?,?,?)";


    public static Order createOrder(String userLogin, List<Product> products) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        int orderId = 0;

        try (Connection connection = DriverManager
                .getConnection(connectionUrl, user, password)) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("SELECT MAX(ID) FROM ORDERS")) {
                try (ResultSet result = preparedStatement.executeQuery()) {
                    while (result.next()) {
                        orderId = result.getInt("MAX(ID)") + 1;
                    }
                }
            }

            for (Product product : products) {
                try (PreparedStatement statement = connection.prepareStatement(SQL_INSERT_ORDERS)) {
                    statement.setInt(1, orderId);
                    statement.setString(2, userLogin);
                    statement.setString(3, product.getArticle());
                    statement.execute();
                }
            }
            return new Order(orderId, userLogin, products);
        }
    }
}
