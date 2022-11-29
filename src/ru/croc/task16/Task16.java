package ru.croc.task16;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task16 {
    private static final String path1 = "/home/kirill/logs";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        ReadLog readLog = new ReadLog();
        List<Log> list = readLog.getLogs(path);
        Collections.sort(list, new LogComparator());

        for (Log log : list) {
            System.out.println(log);
        }
    }

}
