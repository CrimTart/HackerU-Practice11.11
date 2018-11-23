package com.company;

import java.util.ArrayList;
//************************1****************************
public class MyList<T> {
    MyNode<T> first = null;

    void add(T value) {
        MyNode<T> node = new MyNode<>(value);
        if (first == null) {
            first = node;
        }
        else {
            MyNode<T> dop = first;
            while(dop.next != null) {
                dop = dop.next;
            }
            dop.next = node;
        }
    }

    public MyList(MyNode<T> first){
        this.first = first;
    }
//************************2***************************
    void reverse() {
        MyNode<T> last = first;
        while(first.next != null) {
            MyNode<T> b = first.next;
            MyNode<T> c = b.next;
            b.next = last;
            last = b;
            first.next = c;
        }
        first = last;
    }

    ArrayList<T> toArray() {
        ArrayList<T> arr = new ArrayList<>();
        arr.add(first.value);
        MyNode<T> dop = first;
        while(dop.next != null) {
            dop = dop.next;
            arr.add(dop.value);
        }
        return arr;
    }

    @Override
    public String toString() {
        return toArray().toString();
    }
}
