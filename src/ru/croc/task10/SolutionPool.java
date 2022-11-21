package ru.croc.task10;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SolutionPool implements Callable<String> {
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private final static long begin = 321_272_406L;
    private final static long countOperations = 7_710_537_770L;
    //    8_031_810_176   -   321_272_406   =  7_710_537_770

    private int currentThread;
    private int threadNumbers;
    private String hash;
    private static long start;
    private static long end;

    public SolutionPool(int currentThread, int threadNumbers, String hash) {
        this.currentThread = currentThread;
        this.threadNumbers = threadNumbers;
        this.hash = hash;
        this.start = currentThread == 0 ? begin : begin + (countOperations / threadNumbers) * currentThread;
        this.end = currentThread + 1 == threadNumbers ? 8_031_810_176L : begin + (countOperations / threadNumbers) * (currentThread + 1);
    }

    @Override
    public String call() throws Exception {
        for (long i = start; i < end; i++) {
            String password = str((int) i).toLowerCase();
            if (hashPassword(password).equals(hash)) {
                return password;
            }
        }
        return "";
    }

    public static String calculatePassword(int threadsNumbers, String someStringHash)
            throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(threadsNumbers);
        List<Future<String>> list = new ArrayList<>();
        String password = "password doesn't exists";

        for (int i = 0; i < threadsNumbers; i++) {
            list.add(pool.submit(new SolutionPool(i, threadsNumbers, someStringHash)));
        }

        while (true) {
            for (Future<String> future : list) {
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

    static String str(int i) {
        return i < 0 ? "" : str((i / 26) - 1) + (char) (65 + i % 26);
    }

    public static String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
            hex.append(HEX_DIGITS[b & 0x0f]);
        }
        return hex.toString();
    }

    public static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(password.getBytes());
        byte[] bytes = digest.digest();
        return toHexString(bytes);
    }
}
