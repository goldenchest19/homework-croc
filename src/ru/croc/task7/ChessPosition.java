package ru.croc.task7;

public class ChessPosition {
    private static final String[] location = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
    // x - horizontal
    private int xCord;
    // y - vertical
    private int yCord;

    public ChessPosition(int xCord, int yCord) throws IllegalPositionException {
        if (xCord > 7) {
            throw new IllegalPositionException("value should be from a to h");
        }
        this.xCord = xCord;
        if (yCord > 7) {
            throw new IllegalPositionException("value should be from 1 to 8");
        }
        this.yCord = yCord;
    }

    static ChessPosition parse(String position) throws IllegalPositionException {
        // b2 -> return (1, 1)
        String firstEl = position.substring(0, 1);
        String secondEl = position.substring(1);
        int xCord = 0;
        int yCord = Integer.parseInt(secondEl) - 1;

        for (int i = 0; i < location.length; i++) {
            if (location[i].equals(firstEl)) {
                xCord = i;
            }
        }
        if (xCord > 7 || yCord > 7) {
            throw new IllegalPositionException("first cord should be from a to h and second cord should be from 1 to 8");
        }
        return new ChessPosition(xCord, yCord);
    }

    public int getxCord() {
        return xCord;
    }

    public void setxCord(int xCord) throws IllegalPositionException {
        if (xCord > 7) {
            throw new IllegalPositionException("value should be from a to h");
        }
        this.xCord = xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public void setyCord(int yCord) throws IllegalPositionException {
        if (yCord > 7) {
            throw new IllegalPositionException("value should be from 1 to 8");
        }
        this.yCord = yCord;
    }

    @Override
    public String toString() {
        String horizontalCord = location[xCord];
        yCord++;
        String verticalCord = String.valueOf(yCord);

        return horizontalCord + verticalCord;
    }
}
