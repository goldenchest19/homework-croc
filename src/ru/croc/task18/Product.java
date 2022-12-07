package ru.croc.task18;

public class Product {
    private String article;
    private String title;
    private int price;

    public Product(String article, String title, int price) {
        this.article = article;
        this.title = title;
        this.price = price;
    }

    public Product() {
    }

    public String getArticle() {
        return article;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "article='" + article + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
