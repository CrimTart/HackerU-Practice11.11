package com.company;

public class MyNode<T> {
    T value;
    MyNode<T> next = null;
    public MyNode(T value) {
        this.value = value;
    }
}
