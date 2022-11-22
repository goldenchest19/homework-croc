package ru.croc.task13;

import java.io.IOException;
import java.util.List;

public class Task13 {

    public static void main(String[] args) throws IOException {

        System.out.println("1,Мстители: Финал".substring(2));
        RecommendationSystem recommendationSystem = new RecommendationSystem("2,4");
        System.out.println(recommendationSystem.getFilms());
        System.out.println(recommendationSystem.getViewedMovies());
        System.out.println(recommendationSystem.getMoviesCurrentUser());

    }
}
