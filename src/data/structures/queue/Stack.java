package data.structures.queue;

import data.structures.exceptions.IndexOutOfBoundsException;

public class Stack<T> extends AbstractListBasedCollection<T> {

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
}
