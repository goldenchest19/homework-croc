package ru.croc.task5;

import ru.croc.task6.Movable;

public class Figure implements Movable {
    private double xCoord;
    private double yCoord;

    public Figure(double xCoord, double yCoord)  {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public double getxCoord() {
        return xCoord;
    }

    public void setxCoord(double xCoord) {
        this.xCoord = xCoord;
    }

    public double getyCoord() {
        return yCoord;
    }

    public void setyCoord(double yCoord) {
        this.yCoord = yCoord;
    }


    @Override
    public void move(int dx, int dy) {
        setxCoord(xCoord + dx);
        setyCoord(yCoord + dy);
    }
}
