package com.company.task8;

import java.util.ArrayList;

public class Supervisor {
    private int id;
    private ArrayList<Car> cars;
    private ArrayList<Driver> drivers;
    private ArrayList<Trip> trips;

    public Supervisor(int id, ArrayList<Car> cars, ArrayList<Driver> drivers, ArrayList<Trip> trips) {
        this.id = id;
        this.cars = cars;
        this.drivers = drivers;
        this.trips = trips;
    }

    public void banDriver(Driver driver) {
        for (Driver d : drivers) {
            if (d.getId() == driver.getId()) d.setBanned(true);
        }
    }

    public void distibute() {
        boolean totalResult = true;
        for (Trip t : trips) {
            if (!t.isTaken()) {
                totalResult = totalResult && findDriver(t);
            }
        }
        System.out.println(totalResult ? "Distributed all trips!" : "Something went wrong!");
    }

    public boolean findDriver(Trip t) {
        boolean result = false;
        for (Driver d : drivers) {
            if (!d.isBanned() && !d.isBusy()) {
                result = findCar(t, d);
                //if (!result) System.out.println("All cars are taken or on repair.");
                return result;
            }
        }
        return false; //Couldn't find a free driver
    }

    public boolean findCar(Trip t, Driver d) {
        for (Car c : cars) {
            if (!c.isBroken() && !c.isTaken()) {
                d.setBusy(true);
                c.setTaken(true);
                d.setTrip(t);
                d.setCar(c);
                d.drive(); //Actual trip with 1 second wait
                d.setBroken(); //Breaks car every other trip, see Driver
                return true;
            }
        }
        return false; //Couldn't find a free car
    }
}
