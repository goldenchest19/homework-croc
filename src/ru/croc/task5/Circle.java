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
}
