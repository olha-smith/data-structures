package data.structures.queue;

import data.structures.exceptions.IndexOutOfBoundsException;

public class Deque<T> extends AbstractListBasedCollection<T> {

    public boolean insertLast(T e) {
        list.add(e);
        return true;
    }

    public boolean insertFront(T e) throws IndexOutOfBoundsException {
        list.add(0, e);
        return true;
    }

    public T deleteLast() throws IndexOutOfBoundsException {
        return list.remove(list.size() - 1);
    }

    public T deleteFront() throws IndexOutOfBoundsException {
        return list.remove(0);
    }

    public T getFront() throws IndexOutOfBoundsException {
        return list.get(0);
    }

    public T getRear() throws IndexOutOfBoundsException {
        return list.get(list.size() - 1);
    }

}
