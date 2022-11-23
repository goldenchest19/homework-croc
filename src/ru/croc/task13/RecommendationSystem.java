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


    public RecommendationSystem(String inputLine) throws IOException {
        this.inputLine = inputLine;
        ReadData.readAvailableFilms(films);
        ReadData.readViewingHistory(viewedMovies);
        initialize();
    }


    public void initialize() throws IOException {
        String[] array = inputLine.split(",");
        for (int i = 0; i < array.length; i++) {
            moviesCurrentUser.add(Integer.valueOf(array[i]));
        }
    }

    public String searchFilm() {
        viewedMovies = searchUsers();
        viewedMovies = deleteViewedMovies();
        setCountFinalFilms();
        searchMostPopularFilm();
        return films.get(searchMostPopularFilm());
    }

    public ArrayList<ArrayList<Integer>> searchUsers() {
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

    public ArrayList<ArrayList<Integer>> deleteViewedMovies() {
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

    public Map<Integer, String> getFilms() {
        return films;
    }

    public ArrayList<ArrayList<Integer>> getViewedMovies() {
        return viewedMovies;
    }

    public ArrayList<Integer> getMoviesCurrentUser() {
        return moviesCurrentUser;
    }

    public Map<Integer, Integer> getCountFinalFilms() {
        return countFinalFilms;
    }
}
