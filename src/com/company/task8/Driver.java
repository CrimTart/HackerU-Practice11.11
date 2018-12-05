package com.company.task8;

public class Driver {
    private int id;
    private boolean busy = false;
    private boolean banned = false;
    private Car car;
    private Trip trip;

    public Driver(int id, Car car, Trip trip) {
        this.id = id;
        this.car = car;
        this.trip = trip;
    }

    public void setBroken() {
        if (trip != null && trip.getTo().charAt(5) % 2 == 0) {
            this.car.setBroken(true);
        }
    }

    public void drive() {
        this.trip.setTaken(true);
        setBusy(true);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            setBusy(false);
        }
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public boolean isBusy() {
        return busy;
    }

    public boolean isBanned() {
        return banned;
    }

    public Car getCar() {
        return car;
    }

    public Trip getTrip() {
        return trip;
    }
}
