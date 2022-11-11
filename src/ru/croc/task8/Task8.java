package ru.croc.task8;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Task8 {

    public static void main(String[] args) throws IOException {
        String path = args[0];
        System.out.println(readFile(path));
    }

    public static int readFile(String path) throws IOException {
        int count = 0;
        File myObj = new File(path);

        try (Scanner scanner = new Scanner(myObj)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                count++;
            }
        }
        return count;
    }
}
