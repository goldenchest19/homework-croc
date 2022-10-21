package ru.croc.task3;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int[] array = createMassive(line);
        int[] changeArray = permutationNumber(array);
        printArray(changeArray);
    }

    public static int[] createMassive(String line) {
        String[] newLine = line.split(" ");
        int array[] = new int[newLine.length];
        try {
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(newLine[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Введены некорректные данные");
            return new int[1];
        }

        return array;
    }

    public static int[] permutationNumber(int[] array) {
        int maxNumber = array[0];
        int minNumber = array[0];
        int positionMaxNumber = 0;
        int positionMinNumber = 0;
        int temp;
        int[] newArr = array;

        for (int i = 0; i < newArr.length; i++) {

            if (newArr[i] <= minNumber) {
                minNumber = newArr[i];
                positionMinNumber = i;
            }
        }
        temp = newArr[0];
        newArr[0] = minNumber;
        newArr[positionMinNumber] = temp;

        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] >= maxNumber) {
                maxNumber = newArr[i];
                positionMaxNumber = i;
            }
        }
        temp = newArr[newArr.length - 1];
        newArr[newArr.length - 1] = maxNumber;
        newArr[positionMaxNumber] = temp;

        return newArr;
    }

    public static void printArray(int[] array) {
        for (int el : array) {
            System.out.print(el + " ");
        }
    }
}
