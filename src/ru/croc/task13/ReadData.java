package ru.croc.task13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ReadData {
    private static final String pathListOfAvailableFilms = "src/ru/croc/task13/listOfAvailableFiles.txt";
    private static final String pathViewingHistory = "src/ru/croc/task13/viewingHistory.txt";


    public static void readFile(HashMap<Integer, String> hashMap) throws IOException {
        File myObj = new File(pathListOfAvailableFilms);

        try (Scanner scanner = new Scanner(myObj)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                putValue(line, hashMap);
            }
        }
    }

    public static void ReadFile(ArrayList<Integer[]> arrayList) throws FileNotFoundException {
        File myObj = new File(pathViewingHistory);

        try (Scanner scanner = new Scanner(myObj)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                putValue(line, arrayList);
            }
        }
    }

    private static void putValue(String line, HashMap<Integer, String> hashMap) {
        int id = Integer.parseInt(line.substring(0, 1));
        String value = line.substring(2);
        hashMap.put(id, value);
    }

    private static void putValue(String line, ArrayList<Integer[]> arrayList) {
        String[] mas = line.split(",");
        Integer[] arrayIntegers = new Integer[mas.length];
        for (int i = 0; i < arrayIntegers.length; i++) {
            arrayIntegers[i] = Integer.parseInt(mas[i]);
        }
        arrayList.add(arrayIntegers);
    }
}
