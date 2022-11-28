package data.structures.collection;

import data.structures.collection.list.LinkedList;
import data.structures.exceptions.IndexOutOfBoundsException;

public class Queue<T> {

    private LinkedList<T> list = new LinkedList<>();

    @SafeVarargs
    public static <T> Queue<T> of(T... values) {
        Queue<T> queue = new Queue<>();

        for (T value : values) {
            queue.enqueue(value);
        }

        return queue;
    }

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

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
