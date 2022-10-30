package ru.croc.task7;

public class IllegalMoveException extends Exception {
    public IllegalMoveException(ChessPosition prevChessPosition, ChessPosition currentChessPosition) {
        System.out.println("конь так не ходит " + prevChessPosition.toString() + " -> " +
                currentChessPosition.toString());
    }
}
