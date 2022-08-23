package data.structures.queue;

import data.structures.exceptions.IndexOutOfBoundsException;
import data.structures.list.LinkedList;

public class Stack<T> {
    private LinkedList<T> list = new LinkedList<>();
    public T push(T e) {
        list.add(e);
        return e;
    }

    public T pop() throws IndexOutOfBoundsException {
        return list.remove(list.size() - 1);
    }

    public T top() throws IndexOutOfBoundsException {
        return list.get(list.size() - 1);
    }

    public int size() {
        return list.size();
    }
}
