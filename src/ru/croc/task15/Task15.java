package ru.croc.task15;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task15 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        WorkDepartment tree = new WorkDepartment();
        tree.readWordDepartment(path);
        System.out.println(tree.departmentTreeWorkingTime());
    }
}
