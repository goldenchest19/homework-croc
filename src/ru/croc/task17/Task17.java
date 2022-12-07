package ru.croc.task17;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Task17 {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        // Я заметил, что в занятие необходимо реализовать с помощью, командной строки
        // однако на моем компьютере ошибка компиляции при таком наборе, и поэтому я добавил возможность
        // ввода с помощью System.in
        // src/ru/croc/task17/data.csv
//        Scanner scanner = new Scanner(System.in);
//        String pathToCSV = scanner.nextLine();
//        String pathToCSV = args[0];
        Order order = new Order("src/ru/croc/task17/data.csv");
    }
}
