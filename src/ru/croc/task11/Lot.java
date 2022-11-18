package ru.croc.task11;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Lot {

    private volatile float currentPrice;
    private volatile String name;
    private final LocalDateTime finalTime;

    public Lot(float currentPrice, LocalDateTime finalTime) {
        this.currentPrice = currentPrice;
        this.finalTime = finalTime;
    }

    public synchronized void placeBet(float newPrice, String newName) {
        LocalTime time = LocalTime.now();
        if ((newPrice > currentPrice) && (time.isBefore(LocalTime.from(finalTime)))) {
            currentPrice = newPrice;
            name = newName;
        }
    }

    public boolean checkAucExpires() {
        if (LocalTime.now().isAfter(LocalTime.from(finalTime))) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
