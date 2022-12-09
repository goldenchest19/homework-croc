package ru.croc.task17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReadData {

    public static List<List<String>> addOrders(String path) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        List<List<String>> list = new ArrayList<>();
        String row = "";
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");

            list.add(List.of(data));
        }
        csvReader.close();
        return list;
    }

    public static HashSet<List<String>> addUniqueProducts(String path) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        HashSet<List<String>> hashSet = new HashSet<>();
        String row = "";
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");

            List<String> list = new ArrayList<>();
            for (int i = 2; i < data.length; i++) {
                list.add(data[i]);
            }
            hashSet.add(list);
        }
        csvReader.close();
        return hashSet;
    }
}
