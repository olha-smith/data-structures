package data.structures.queue;

import data.structures.list.LinkedList;

public class Queue<T> {

    private LinkedList<T> list = new LinkedList<>();

    public T enqueue(T e) {
        list.add(e);
        return e;
    }
}
