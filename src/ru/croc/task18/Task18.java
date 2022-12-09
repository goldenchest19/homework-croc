package ru.croc.task18;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Task18 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(WorkWithProduct.findProduct("Т5"));
        Product product = new Product("Т9", "USB", 2281);
        WorkWithProduct.createProduct(product);

        Product newProduct = new Product("Т3", "ноутбук", 1337);
        WorkWithProduct.updateProduct(newProduct);

        WorkWithProduct.deleteProduct("Т2");

        List<Product> products = new ArrayList<>();
        products.add(new Product("Т4", "Блок питания", 200));
        products.add(new Product("Т4", "Блок питания", 200));
        products.add(new Product("Т5", "Видеокарта", 15000));

        WorkWithOrder.createOrder("kolyan", products);
    }
}
