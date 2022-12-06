package ru.croc.task18;

import java.sql.SQLException;

public class Task18 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(WorkWithDB.findProduct("Т3"));
        Product product = new Product();
        product.setArticle("Т6");
        product.setTitle("беляши");
        product.setPrice(2281);
//        WorkWithDBProduct.createProduct(product);
        Product newProduct = new Product();
        newProduct.setArticle("Т3");
        newProduct.setTitle("котлеты");
        newProduct.setPrice(1337);
//        WorkWithDBProduct.updateProduct(newProduct);
        WorkWithDB.deleteProduct("Т10");
    }
}
