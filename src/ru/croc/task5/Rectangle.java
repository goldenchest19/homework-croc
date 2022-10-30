package ru.croc.task5;

import ru.croc.task6.Movable;

public class Rectangle extends Figure implements Movable {
    private double xCoord2;
    private double yCoord2;

    public Rectangle(double xCoord, double yCoord,double xCoord2, double yCoord2) throws Exception{
        super(xCoord, yCoord);
        if (xCoord2 < xCoord) {
            throw new Exception("first xCoord should be less then xCoord2");
        }
        if (yCoord2 < yCoord) {
            throw new Exception("first yCoord should be less then yCoord2");
        }
        this.xCoord2 = xCoord2;
        this.yCoord2 = yCoord2;
    }

    public double getxCoord2() {
        return xCoord2;
    }

    public void setxCoord2(double xCoord2) throws Exception {
        if (xCoord2 < getxCoord()) {
            throw new Exception("first xCoord should be less then xCoord2");
        }
        this.xCoord2 = xCoord2;
    }

    public double getyCoord2() {
        return yCoord2;
    }

    public void setyCoord2(double yCoord2) throws Exception{
        if (yCoord2 < getyCoord()) {
            throw new Exception("first yCoord should be less then yCoord2");
        }
        this.yCoord2 = yCoord2;
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
        this.xCoord2 = xCoord2 + dx;
        this.yCoord2 = yCoord2 + dy;
    }
}
