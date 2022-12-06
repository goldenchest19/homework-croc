package ru.croc.task17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReadData {
    // считываем данные из файла, и записываем их в list и hashset
    public static void readCSVFile(List<List<String>> list, HashSet<List<String>> uniqueProducts,
                                   HashSet<List<String>> uniqueUsers,String path) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        String row = "";
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");

            list.add(List.of(data));
            initialUniqueProducts(uniqueProducts, data);
            initialUniqueUsers(uniqueUsers, data);
        }
        csvReader.close();
    }

    private static void initialUniqueProducts(HashSet<List<String>> hashSet, String[] strings) {
        List<String> list = new ArrayList<>();
        for (int i = 2; i < strings.length; i++) {
            list.add(strings[i]);
        }
        hashSet.add(list);
    }

    private static void initialUniqueUsers(HashSet<List<String>> hashSet, String[] strings) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            list.add(strings[i]);
        }
        hashSet.add(list);
    }

}
