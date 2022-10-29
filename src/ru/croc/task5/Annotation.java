package ru.croc.task5;

public class Annotation {
    private String title;
    private Figure figure;

    public Annotation(String title, Figure figure) {
        this.title = title;
        this.figure = figure;
    }

    @Override
    public String toString() {
         if (figure instanceof Rectangle) {
             String finalString = String.format("R (<%s>, <%s>), (<%s>, <%s>): %s",
                     figure.getxCoord(), figure.getyCoord(),
                     ((Rectangle) figure).getxCoord2(), ((Rectangle) figure).getyCoord2(), title
             );
             return finalString;
         }
        String finalString = String.format("C (<%s>, <%s>), %s: %s",
                figure.getxCoord(), figure.getyCoord(),
                ((Circle) figure).getRadius(), title
        );
         return finalString;
    }
}
