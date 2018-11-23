package com.company;

public class Tree<T> {
    T data;
    Tree<T> left;
    Tree<T> right;

    public Tree(T data, Tree<T> left, Tree<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
