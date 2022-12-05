package ru.croc.task17;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Task17 {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        List<List<String>> list =  ReadData.readCSVFile();
        for (List<String> strings : list) {
            System.out.print(strings + " ");
        }
        Table.addDataToDB(list);
    }
}
