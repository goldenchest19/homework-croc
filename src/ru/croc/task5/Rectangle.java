package ru.croc.task5;

public class Rectangle extends Figure {
    private double xCoord2;
    private double yCoord2;

    public Rectangle(double xCoord, double yCoord, double xCoord2, double yCoord2) throws Exception {
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

    public void setyCoord2(double yCoord2) throws Exception {
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

//  the idea of the check is that the point given to us
//  should be included in the area of the figure => x1<=x<=x2 and y1<=y<=y2
    @Override
    public boolean searchPoint(int x, int y) {
        return comparePoint(x, y);
    }

    @Override
    public String toString() {
        String prevString = super.toString();
        String currentString = String.format("(%s, %s)",
                getxCoord2(), getyCoord2()
        );
        return "R " + prevString + ", " + currentString + ": ";
    }

    // this method is an auxiliary method for finding a point in a shape
    private boolean comparePoint(int x, int y) {
        return (x >= getxCoord() && x <= xCoord2) && (y >= getyCoord() && y <= yCoord2);
    }
}
