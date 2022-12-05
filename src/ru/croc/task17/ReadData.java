package ru.croc.task17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadData {
    private static final String pathToCSV = "src/ru/croc/task17/data.csv";

    public static List<List<String>> readCSVFile() throws IOException {
        List<List<String>> list = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCSV));
        String row = "";
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            // do something with the data
            list.add(List.of(data));
        }
        csvReader.close();
        return list;
    }

}
