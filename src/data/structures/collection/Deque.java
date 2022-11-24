package data.structures.collection;

import data.structures.collection.list.LinkedList;
import data.structures.exceptions.IndexOutOfBoundsException;

public class Deque<T> {

    private LinkedList<T> list = new LinkedList<>();

    @SafeVarargs
    public static <T> Deque<T> of(T... values) {
        Deque<T> deque = new Deque<>();

        for (T value : values) {
            deque.insertLast(value);
        }

        return deque;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T insertLast(T e) {
        list.add(e);
        return e;
    }

    public T insertFront(T e) throws IndexOutOfBoundsException {
        list.add(0, e);
        return e;
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
