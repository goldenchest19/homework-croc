package ru.croc.task18;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Task18 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        System.out.println(WorkWithProduct.findProduct("Т3"));
//        Product product = new Product();
//        product.setArticle("Т6");
//        product.setTitle("беляши");
//        product.setPrice(2281);
//        WorkWithProduct.createProduct(product);
//
//        Product newProduct = new Product();
//        newProduct.setArticle("Т3");
//        newProduct.setTitle("котлеты");
//        newProduct.setPrice(1337);
//        WorkWithProduct.updateProduct(newProduct);
//        WorkWithProduct.deleteProduct("Т1");

//        WorkWithOrder.addUser("dima");
//        System.out.println(WorkWithOrder.checkUser("vasya"));

        List<Product> products = new ArrayList<>();
        products.add(new Product("Т1"));
        products.add(new Product("Т2"));
//        products.add(new Product("Т2"));
//        products.add(new Product("Т3"));
//        products.add(new Product("Т5"));

        WorkWithOrder.createOrder("vasya", products);
    }
}
