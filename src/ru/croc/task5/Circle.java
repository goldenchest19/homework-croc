package ru.croc.task5;

public class Circle extends Figure {
    private double radius;

    public Circle(double xCoord, double yCoord, double radius) {
        super(xCoord, yCoord);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean searchPoint(int x, int y) {
        double distanceFromPointToCenter = Math.sqrt(
                (x - getxCoord()) * (x - getxCoord()) + (y - getyCoord()) * (y - getyCoord())
        );
        return distanceFromPointToCenter <= radius;
    }

    @Override
    public String toString() {
        String prevString = super.toString();
        String finalString = "С " + prevString + ", " + radius + ": ";
        return finalString;
    }
}
