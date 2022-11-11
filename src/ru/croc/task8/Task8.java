package ru.croc.task8;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Task8 {

    public static void main(String[] args) throws IOException {
        String path1 = args[0];
        String line = "src/ru/croc/task8/input.txt";
        String[] arr = line.split("/");
//        for (String s : arr) {
//            System.out.println(s);
//        }
//        System.out.println(String.valueOf(arr));

//        System.out.println(path1);
        readFile();
    }

    public static void readFile() throws IOException {
        int count = 0;
        String[] arr = new String[10];
        Path path = Path.of("src", "ru", "croc", "task8", "input.txt");
//        Path path2 = Path.of(String.valueOf(arr));
        try (Scanner scanner = new Scanner()) {

            while (scanner.hasNext()) {
                String word = scanner.next();
                System.out.println(word);
                count++;
            }
        }
        System.out.println(count);
    }

}
