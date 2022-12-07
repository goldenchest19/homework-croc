package ru.croc.task18;

import java.util.List;

public class Order{
    private int id;
    private String userLogin;

    private List<Product> products;

    public Order() {
    }

    public Order(int id, String userLogin, List<Product> products) {
        this.id = id;
        this.userLogin = userLogin;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
