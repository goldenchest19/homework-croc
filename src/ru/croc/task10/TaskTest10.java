package ru.croc.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskTest10 {
    //"abcdefghijklmnopqrstuvwxyz
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int threadsNumber = 8;
        String hash1 = "40682260CC011947FC2D0B1A927138C5";
        String hash2 = "74E2DFE227A0400F3A148125CA532B25"; // aaaaabb
        String hash3 = "80B843C20E59F81726E2AE7BE8A02A63"; // evgtyfw
        String hash4 = "647DC159BB2BF2151CBAAEC29AD35FA8"; //


        System.out.println(calculatePassword(threadsNumber, hash1) + " " + hash1);
    }

    public static String calculatePassword(int threadsNumbers, String someStringHash)
            throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(threadsNumbers);
        List<Future<String>> list = new ArrayList<>();
        String password = "password doesn't exists";

        for (int i = 0; i < threadsNumbers; i++) {
            list.add(pool.submit(new SolutionPoolTest(i, threadsNumbers, someStringHash)));
        }

        for (Future<String> future : list) {
//            System.out.println("зашел");
            String futureGet = future.get();
            if (!futureGet.equals("")) {
                pool.shutdown();
                password = futureGet;
                break;
            }
        }
        return password;
    }
}
