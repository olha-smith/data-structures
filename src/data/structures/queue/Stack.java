package data.structures.queue;

import data.structures.list.LinkedList;

public class Stack<T> {
    private LinkedList<T> list = new LinkedList<>();
    public T push(T e) {
        list.add(e);
        return e;
    }
}
