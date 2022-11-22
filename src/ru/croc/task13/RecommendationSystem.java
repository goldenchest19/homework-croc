package ru.croc.task13;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecommendationSystem {
    private Map<Integer, String> films = new HashMap<>();
    private ArrayList<ArrayList<Integer>> viewedMovies = new ArrayList<>();
    private String inputLine;
    private ArrayList<Integer> moviesCurrentUser = new ArrayList<>();
    

    public RecommendationSystem(String inputLine) throws IOException {
        this.inputLine = inputLine;
        ReadData.readAvailableFilms(films);
        ReadData.readFile(viewedMovies);
        initialize();
    }


    public void initialize() throws IOException {
        String[] array = inputLine.split(",");
        for (int i = 0; i < array.length; i++) {
            moviesCurrentUser.add(Integer.valueOf(array[i]));
        }
    }

    public String searchFilm() {
        return null;
    }

    public Map<Integer, String> getFilms() {
        return films;
    }

    public ArrayList<ArrayList<Integer>> getViewedMovies() {
        return viewedMovies;
    }

    public ArrayList<Integer> getMoviesCurrentUser() {
        return moviesCurrentUser;
    }
}
