package ru.croc.task17;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

public class ParseData {
    private List<List<String>> orders;
    private HashSet<List<String>> uniqueProducts;

    public ParseData(String path) throws IOException, SQLException, ClassNotFoundException {
        this.orders = ReadData.addOrders(path);
        this.uniqueProducts = ReadData.addUniqueProducts(path);
    }

    public void parseDataToDB() throws SQLException, ClassNotFoundException {
        Table table = new Table(orders, uniqueProducts);
    }
}
