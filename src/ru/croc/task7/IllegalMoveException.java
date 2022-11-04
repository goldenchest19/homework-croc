package ru.croc.task7;

public class IllegalMoveException extends Exception {
    ChessPosition prevChessPosition;
    ChessPosition currentChessPosition;

    public IllegalMoveException(ChessPosition prevChessPosition, ChessPosition currentChessPosition) {
        this.prevChessPosition = prevChessPosition;
        this.currentChessPosition = currentChessPosition;
        System.out.println(getMessage());
    }

    @Override
    public String getMessage() {
        return "конь так не ходит " + prevChessPosition.toString() + " -> " +
                currentChessPosition.toString();
    }
}
