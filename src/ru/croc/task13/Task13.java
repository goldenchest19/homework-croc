package ru.croc.task13;

import java.io.IOException;
import java.util.Scanner;

public class Task13 {

    public static void main(String[] args) throws IOException {
        // input - 1,2,4
        // при тесте [3,3,3,1,1,2,5,4] , [1,1,3,4,4,4,5], [2,3,3,3,5]
//        получаем: 1 шаг: [3,3,3,1,1,2,5,4] , [1,1,3,4,4,4,5] , [2,3,3,3,5]
//        2 шаг: [3,3,3,5] , [3,5]
//        3 шаг: {3:4, 5:2}
//        Вывод - Дюна
        Scanner scanner = new Scanner(System.in);
        String filmsByUser = scanner.nextLine();
        RecommendationSystem recommendationSystem = new RecommendationSystem(filmsByUser);
        System.out.println(recommendationSystem.searchFilm());
    }
}
