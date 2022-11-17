package ru.croc.task11;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Lot {

    private float currentPrice;
    private String name;
    private LocalDateTime finalTime;
    private boolean flag = false;

    public Lot(float currentPrice, LocalDateTime finalTime) {
        this.currentPrice = currentPrice;
        this.finalTime = finalTime;
    }

    public synchronized void placeBet(float newPrice, String newName) {
        LocalTime time = LocalTime.now();
        if ((newPrice > currentPrice) && (time.isBefore(LocalTime.from(finalTime)))) {
            currentPrice = newPrice;
            name = newName;
        } if (time.isAfter(LocalTime.from(finalTime))) {
            flag = true;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isFlag() {
        return flag;
    }
}
