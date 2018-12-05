package com.company.task8;

public class Car {
    private int id;
    private boolean broken = false;
    private boolean taken = false;

    public Car(int id) {
        this.id = id;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }

    public void setTaken(boolean free) {
        this.taken = free;
    }

    public int getId() {
        return id;
    }

    public boolean isBroken() {
        return broken;
    }

    public boolean isTaken() {
        return taken;
    }
}
