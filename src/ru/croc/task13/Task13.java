package ru.croc.task13;

import java.io.IOException;

public class Task13 {

    public static void main(String[] args) throws IOException {

        RecommendationSystem recommendationSystem = new RecommendationSystem("1,2,4");
        System.out.println(recommendationSystem.searchFilm());
    }
}
