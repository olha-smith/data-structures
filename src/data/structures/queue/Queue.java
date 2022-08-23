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
        return list.remove(0);
    }

    public T front() throws IndexOutOfBoundsException {
        return list.get(0);
    }

    public T rear() throws IndexOutOfBoundsException {
        return list.get(list.size() - 1);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
