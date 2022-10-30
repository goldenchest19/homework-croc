package ru.croc.task5;

import ru.croc.task6.Movable;

public class Circle extends Figure implements Movable {
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
