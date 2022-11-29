package ru.croc.task16;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        ReadLog readLog = new ReadLog();
        List<Log> list = readLog.getLogs(path);
        list.sort(new LogComparator());

        for (Log log : list) {
            System.out.println(log);
        }
    }

}
