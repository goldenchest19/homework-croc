package ru.croc.task9;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class Task9 {

    public static void main(String[] args) {
//        КРОК/работа/src/./../../универ/../../../мемы/котики
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.println(improvePath(path));
    }

    public static String improvePath(String path) {
        String[] str = path.split("/./|/");
//        in this cycle, the condition is checked for the transition
//        to the parent directory from the current
//        one. when the condition is met, we remove two
//        array elements using array concatenation,
//        the counter returns to the previous position in line 30
        for (int i = 0; i < str.length - 1; i++) {
            if (!str[i].equals("..") && str[i + 1].equals("..")) {
                str = Stream.concat(
                                Arrays.stream(
                                        Arrays.copyOfRange(str, 0, i)),
                                Arrays.stream(
                                        Arrays.copyOfRange(str, i + 2, str.length)))
                        .toArray(String[]::new);
                i = -1;
            }
        }
        String result = "";
        if (!Objects.equals(str[0], "..")) {
            result = "./";
        }

        StringBuilder resultBuilder = new StringBuilder(result);
        for (String i : str) {
            resultBuilder.append(i).append("/");
        }
        return resultBuilder.toString();
    }
}
