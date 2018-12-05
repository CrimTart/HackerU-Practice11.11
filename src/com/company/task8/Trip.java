package com.company.task8;

public class Trip {
    private String from;
    private String to;
    private boolean taken = false;

    public Trip(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public boolean isTaken() {
        return taken;
    }

    public String toString() {
        return "from " + from + " to " + to;
    }
}
