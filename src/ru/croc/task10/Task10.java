package ru.croc.task10;

import java.util.concurrent.ExecutionException;

public class Task10 {
//"abcdefghijklmnopqrstuvwxyz
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int threadsNumber = 4;
        String hash1 = "40682260CC011947FC2D0B1A927138C5";
        String hash2 = "74E2DFE227A0400F3A148125CA532B25"; // aaaaabb
        String hash3 = "80B843C20E59F81726E2AE7BE8A02A63"; // evgtyfw


        System.out.println(SolutionPool.calculatePassword(threadsNumber, hash1) + " " + hash1);
    }
}
