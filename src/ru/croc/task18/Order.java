package ru.croc.task18;

import java.util.List;

public class Order {
    private int id;
    private String userLogin;

    private List<Product> products;

    public Order(int id, String userLogin, List<Product> products) {
        this.id = id;
        this.userLogin = userLogin;
        this.products = products;
    }
}
