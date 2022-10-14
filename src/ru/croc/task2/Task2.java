package ru.croc.task2;

import java.math.BigDecimal;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bytes = scanner.nextLine();
        BigDecimal bigDecimal = new BigDecimal(bytes);

        printBytes(bigDecimal);
    }


    public static void printBytes(BigDecimal number) {
        BigDecimal numberZero = new BigDecimal(0);
        if (number.compareTo(numberZero) == -1) {
            System.out.println("Введены некоректные данные");
            return;
        }
        int count = 0;
        String[] degreeByte = new String[]{"B", "KB", "MB", "GB", "TB", "PB"};
        BigDecimal newNumber = number;
        BigDecimal checkingNumber = new BigDecimal(1024);

        while (newNumber.compareTo(checkingNumber) == 1 || newNumber.compareTo(checkingNumber) == 0) {
            count++;
            newNumber = newNumber.divide(checkingNumber);
        }

        double someValue = newNumber.doubleValue();
        String finalNumber = String.format("%.1f", someValue);
        System.out.println(Double.parseDouble(finalNumber) + " " + degreeByte[count]);

    }
}

