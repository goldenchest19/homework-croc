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
        // Цикл работает до тех пор, пока находит совпадения до того, как дойдёт до конца
        for (int i = 0; i < str.length - 1; i++) {
            //проверка на переход в родительскую директорию из текущей
            if (!str[i].equals("..") && str[i + 1].equals("..")) {
                // Убираем элементы массива, методом склеивания двух подмассивов
                str = Stream.concat(Arrays.stream(Arrays.copyOfRange(str, 0, i)),
                                Arrays.stream(Arrays.copyOfRange(str, i + 2, str.length)))
                        .toArray(String[]::new);
                // возвращаем цикл в исходное состояние
                i = -1;
            }
        }
        //преобразовываем массив обратно по правилам формирования адресации
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
