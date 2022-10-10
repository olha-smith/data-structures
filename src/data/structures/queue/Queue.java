package data.structures.queue;

import data.structures.exceptions.IndexOutOfBoundsException;

public class Queue<T> extends AbstractListBasedCollection<T> {

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
}
