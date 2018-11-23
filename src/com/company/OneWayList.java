package com.company;
//**********************1.1************************
public class OneWayList<T> {
    T data;
    OneWayList next;

    public OneWayList(T data, OneWayList<T> next) {
        this.data = data;
        this.next = next;
    }

    public void append(T data) {
        OneWayList<T> curr = this;
        while(curr.next != null ) {
            curr = curr.next;
        }
        curr.next = new OneWayList<T>(data, null);
    }
}
