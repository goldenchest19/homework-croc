package ru.croc.task18;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Task18 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(WorkWithProduct.findProduct("Т3"));
        Product product = new Product();
        product.setArticle("Т7");
        product.setTitle("USB");
        product.setPrice(2281);
        WorkWithProduct.createProduct(product);
        Product newProduct = new Product();
        newProduct.setArticle("Т3");
        newProduct.setTitle("настольная лампа");
        newProduct.setPrice(1337);
        WorkWithProduct.updateProduct(newProduct);
        WorkWithProduct.deleteProduct("Т1");

        List<Product> products = new ArrayList<>();
        products.add(new Product("Т4", "Блок питания", 200));
        products.add(new Product("Т4", "Блок питания", 200));
        products.add(new Product("Т6", "беляши", 2281));

        WorkWithOrder.createOrder("vasya",products);
    }
}
