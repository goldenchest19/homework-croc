package ru.croc.task7;

import java.util.Scanner;

public class Task7 {

    public static void main(String[] args) throws IllegalPositionException, IllegalMoveException {

//      a string of knight positions is submitted to the input
//      example: d4 c6 d8 f7 h6 g4 -> OK
        Scanner scanner = new Scanner(System.in);
        String lineChessPoint = scanner.nextLine().toLowerCase();
        String[] arrayChessPoint = lineChessPoint.split(" ");
        ChessPosition[] chessPositions = new ChessPosition[arrayChessPoint.length];

        for (int i = 0; i < arrayChessPoint.length; i++) {
            chessPositions[i] = ChessPosition.parse(arrayChessPoint[i]);
        }

        MovePiece.checkKnightMove(chessPositions);
    }
}
