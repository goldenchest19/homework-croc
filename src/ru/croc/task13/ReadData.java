package ru.croc.task13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class ReadData {
    private static final String pathListOfAvailableFilms = "src/ru/croc/task13/listOfAvailableFiles.txt";
    private static final String pathViewingHistory = "src/ru/croc/task13/viewingHistory.txt";


    public static void readAvailableFilms(Map<Integer, String> hashMap) throws IOException {
        File myObj = new File(pathListOfAvailableFilms);

        try (Scanner scanner = new Scanner(myObj)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                putFilmsFromUsers(line, hashMap);
            }
        }
    }

    public static void readViewingHistory(ArrayList<ArrayList<Integer>> arrayList) throws FileNotFoundException {
        File myObj = new File(pathViewingHistory);

        try (Scanner scanner = new Scanner(myObj)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                putValue(line, arrayList);
            }
        }
    }

    private static void putFilmsFromUsers(String line, Map<Integer, String> hashMap) {
        int id = Integer.parseInt(line.substring(0, 1));
        String value = line.substring(2);
        hashMap.put(id, value);
    }

    private static void putValue(String line, ArrayList<ArrayList<Integer>> arrayList) {
        String[] mas = line.split(",");
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> newArrayList = new ArrayList<>();

        for (int i = 0; i < mas.length; i++) {
            hashSet.add(Integer.parseInt(mas[i]));
        }

        for (Integer integer : hashSet) {
            newArrayList.add(integer);
        }

        arrayList.add(newArrayList);
    }
}