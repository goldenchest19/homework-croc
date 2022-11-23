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
    private Map<Integer, Integer> countFinalFilms = new HashMap<>();

    // when creating an object, the constructor also
    // initializes two read files, and writes the entered value to the ArrayList.
    public RecommendationSystem(String inputLine) throws IOException {
        this.inputLine = inputLine;
        ReadData.readAvailableFilms(films);
        ReadData.readViewingHistory(viewedMovies);
        initialize();
    }

    // This method parse inputLine to ArrayList
    public void initialize() throws IOException {
        String[] array = inputLine.split(",");
        for (int i = 0; i < array.length; i++) {
            moviesCurrentUser.add(Integer.valueOf(array[i]));
        }
    }

    // the main control block that calls the auxiliary methods
    public String searchFilm() {
        viewedMovies = searchUsers();
        viewedMovies = deleteViewedMovies();
        setCountFinalFilms();
        searchMostPopularFilm();
        return films.get(searchMostPopularFilm());
    }

    // this method implements the first point of the algorithm,
    // and removes the user who has watched less
    // than 50 percent of the specified movies
    private ArrayList<ArrayList<Integer>> searchUsers() {
        int count = 0;
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        for (int i = 0; i < viewedMovies.size(); i++) {

            for (int j = 0; j < viewedMovies.get(i).size(); j++) {

                for (Integer filmCurrentUser : moviesCurrentUser) {

                    if (viewedMovies.get(i).get(j) == filmCurrentUser) {
                        count++;
                    }
                }
            }
            if (count >= (viewedMovies.get(i).size() + 1) / 2) {
                arrayList.add(viewedMovies.get(i));
            }
            count = 0;
        }
        return arrayList;
    }

    // this method implements the second point of the algorithm,
    // and delete films, which the specified user has already viewed
    private ArrayList<ArrayList<Integer>> deleteViewedMovies() {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> mas = new ArrayList<>();

        for (int i = 0; i < viewedMovies.size(); i++) {

            for (int j = 0; j < viewedMovies.get(i).size(); j++) {
                if (!moviesCurrentUser.contains(viewedMovies.get(i).get(j))) {
                    mas.add(viewedMovies.get(i).get(j));
                }
            }
            if (mas.size() > 0) {
                arrayList.add(mas);
            }
            mas = new ArrayList<>();
        }
        return arrayList;
    }

    // this method implements the third point of the algorithm,
    // we find the most popular movie among all the remaining films
    public Integer searchMostPopularFilm() {
        Integer recommendedMovie = null;
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : countFinalFilms.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                recommendedMovie = entry.getKey();
            }
        }
        return recommendedMovie;
    }


    private void setCountFinalFilms() {
        for (ArrayList<Integer> viewedMovie : viewedMovies) {
            for (Integer film : viewedMovie) {
                Integer count = countFinalFilms.get(film);

                if (count == null) {
                    count = 0;
                }
                count++;
                countFinalFilms.put(film, count);
            }
        }
    }
}
