package com.company.task8;

/*
1) Диспетчер распределяет заявки на Рейсы между Водителями и назначает для этого Автомобиль.
2) Водитель может сделать заявку на ремонт.
3) Диспетчер может отстранить Водителя от работы.
4) Водитель делает отметку о выполнении Рейса и состоянии Автомобиля.*/

import java.util.ArrayList;

public class Autobase {
    private ArrayList<Car> cars;
    private ArrayList<Driver> drivers;
    private ArrayList<Trip> trips;
    private Supervisor supervisor;

    public Autobase(ArrayList<Car> cars, ArrayList<Driver> drivers, ArrayList<Trip> trips, Supervisor supervisor) {
        this.cars = cars;
        this.drivers = drivers;
        this.trips = trips;
        this.supervisor = supervisor;
    }

    public void fillTrips() {
        StringBuilder sb = new StringBuilder();
        sb.append("Town 0");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Town 1");
        int i = 0;
        while (i<10) {
            trips.add(new Trip(sb.toString(), sb2.toString()));
            i++;
            sb = new StringBuilder(sb2);
            sb2.deleteCharAt(5);
            sb2.append(i+1);
        }
    }

    public void printTrips() {
        for (Trip t:
             trips) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        Autobase base = new Autobase(null, null, new ArrayList<Trip>(), null);
        base.fillTrips();
        base.printTrips();
    }
}
