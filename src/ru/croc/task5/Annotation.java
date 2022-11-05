package ru.croc.task5;

public class Annotation {
    private String title;
    private Figure figure;

    public Annotation(String title, Figure figure) {
        this.title = title;
        this.figure = figure;
    }

    public String getTitle() {
        return title;
    }

    public Figure getFigure() {
        return figure;
    }

    @Override
    public String toString() {
        return figure.toString() + title;
    }
}
