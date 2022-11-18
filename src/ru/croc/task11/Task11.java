package ru.croc.task11;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Task11 {

    public static void main(String[] args) throws InterruptedException {
        Lot lot = new Lot(100, LocalDateTime.of(2022, 11, 19, 0, 28,50));
        List<LotThread> list = new ArrayList<>();
        list.add(new LotThread(lot,  "Dima1", 150));
        list.add(new LotThread(lot,  "Dima2", 1250));
        list.add(new LotThread(lot,  "Dima3", 1540));
        list.add(new LotThread(lot,  "Dima4", 1507));
        list.add(new LotThread(lot,  "Dima5", 150222));
        list.add(new LotThread(lot,  "Dima6", 1530));
        list.add(new LotThread(lot,  "Dima7", 1530));
        list.add(new LotThread(lot,  "Dima8", 1530));
        list.add(new LotThread(lot,  "Dima9", 15330));
        list.add(new LotThread(lot,  "Dima10", 1504344));

        for (LotThread thread : list) {
            thread.start();
        }

        for (LotThread thread : list) {
            thread.join();
        }
    }
}
