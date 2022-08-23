package data.structures.queue;

import data.structures.exceptions.IndexOutOfBoundsException;
import data.structures.list.LinkedList;

public class Deque<T> {
    private LinkedList<T> list = new LinkedList<>();

    public boolean insertLast(T e) {
        list.add(e);
        return true;
    }

    public T getRear() throws IndexOutOfBoundsException {
        return list.get(list.size() - 1);
    }

}
