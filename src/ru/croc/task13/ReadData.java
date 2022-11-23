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

    /**
     * This method parses movies, and then writes them to hashmap
     * @param hashMap transfer here the file with your movie that needs to be parsed
     *
     */
    public static void readAvailableFilms(Map<Integer, String> hashMap) throws IOException {
        File myObj = new File(pathListOfAvailableFilms);

        try (Scanner scanner = new Scanner(myObj)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                putFilmsFromUsers(line, hashMap);
            }
        }
    }

    /**
     * This method records the history of users in a list of lists
     * @param arrayList here is a list of lists in which you need to record user views
     * @throws FileNotFoundException
     */
    public static void readViewingHistoryWithoutDuplicate(ArrayList<ArrayList<Integer>> arrayList) throws FileNotFoundException {
        File myObj = new File(pathViewingHistory);

        try (Scanner scanner = new Scanner(myObj)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                putValueWithoutDuplicate(line, arrayList);
            }
        }
    }

    public static void readViewingHistoryWithDuplicate(ArrayList<ArrayList<Integer>> arrayList) throws FileNotFoundException {
        File myObj = new File(pathViewingHistory);

        try (Scanner scanner = new Scanner(myObj)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                putValueWithDuplicate(line, arrayList);
            }
        }
    }



    // This method helps readAvailableFilms parse data
    private static void putFilmsFromUsers(String line, Map<Integer, String> hashMap) {
        int id = Integer.parseInt(line.substring(0, 1));
        String value = line.substring(2);
        hashMap.put(id, value);
    }

    // This method helps readViewingHistory parse data
    private static void putValueWithoutDuplicate(String line, ArrayList<ArrayList<Integer>> arrayList) {
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

    private static void putValueWithDuplicate(String line, ArrayList<ArrayList<Integer>> arrayList) {
        String[] mas = line.split(",");
        ArrayList<Integer> newArrayList = new ArrayList<>();

        for (int i = 0; i < mas.length; i++) {
            newArrayList.add(Integer.valueOf(mas[i]));
        }

        arrayList.add(newArrayList);
    }
}
