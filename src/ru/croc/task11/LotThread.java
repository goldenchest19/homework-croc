package ru.croc.task11;

public class LotThread extends Thread {

    private final Lot lot;
    private String name;
    private float bet;

    public LotThread(Lot lot, String name, float bet) {
        this.lot = lot;
        this.name = name;
        this.bet = bet;
    }

    @Override
    public void run() {
        while (true) {
            lot.placeBet(bet, name);
            if (lot.isFlag()) {
                System.out.println(lot.getName());
                break;
            }
        }
    }
}
