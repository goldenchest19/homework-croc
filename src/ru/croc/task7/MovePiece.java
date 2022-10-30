package ru.croc.task7;

public class MovePiece {
    public static void checkKnightMove(ChessPosition... chessPositions) throws IllegalMoveException {
        ChessPosition prevChestPosition = chessPositions[0];
        int xCordPrev = prevChestPosition.getxCord();
        int yCordPrev = prevChestPosition.getyCord();

        for (int i = 1; i < chessPositions.length; i++) {
            int xCordCurrent = chessPositions[i].getxCord();
            int yCordCurrent = chessPositions[i].getyCord();

            if (moveKnight(xCordPrev, yCordPrev, xCordCurrent, yCordCurrent)) {
                xCordPrev = xCordCurrent;
                yCordPrev = yCordCurrent;
            } else {
                throw new IllegalMoveException(chessPositions[i-1], chessPositions[i]);
            }
        }
        System.out.println("OK");
    }

    /**
     * this method checks whether the knight can make such a move
     * @param xCordPrev the x coordinate from which the knight makes a move
     * @param yCordPrev the y coordinate from which the knight makes a move
     * @param xCordCurrent the x coordinate at which the knight makes a move
     * @param yCordCurrent the y coordinate at which the knight makes a move
     * @return true if the knight can make such a move, false similarly
     */
    public static boolean moveKnight(int xCordPrev, int yCordPrev, int xCordCurrent, int yCordCurrent) {
        return ((Math.abs(xCordPrev - xCordCurrent) == 2) && (Math.abs(yCordPrev - yCordCurrent) == 1)) ||
                ((Math.abs(xCordPrev - xCordCurrent) == 1) && (Math.abs(yCordPrev - yCordCurrent) == 2));
    }
}
