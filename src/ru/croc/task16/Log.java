package ru.croc.task16;

public class Log {
    private Long time;
    private String log;

    public Log(Long time, String log) {
        this.time = time;
        this.log = log;
    }

    public Long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return log;
    }
}
