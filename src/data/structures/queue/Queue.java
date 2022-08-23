package data.structures.queue;

import data.structures.exceptions.IndexOutOfBoundsException;
import data.structures.list.LinkedList;

public class Queue<T> {

    private LinkedList<T> list = new LinkedList<>();

    public T enqueue(T e) {
        list.add(e);
        return e;
    }

    public T dequeue() throws IndexOutOfBoundsException {
        return list.remove(list.size() - 1);
    }

    public T front() throws IndexOutOfBoundsException {
        return list.get(0);
    }
}
