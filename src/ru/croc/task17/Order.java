package ru.croc.task17;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Order {
    private List<List<String>> orders = new ArrayList<>();
    private HashSet<List<String>> uniqueProducts = new HashSet<>();

    public Order(String path) throws IOException, SQLException, ClassNotFoundException {
        ReadData.readCSVFile(orders, uniqueProducts, path);
        Table.addDataToDB(orders, uniqueProducts);
    }
}
