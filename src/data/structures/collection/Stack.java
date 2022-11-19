package data.structures.collection;

import data.structures.collection.list.LinkedList;
import data.structures.exceptions.IndexOutOfBoundsException;

public class Stack<T> {

    private LinkedList<T> list = new LinkedList<>();

    @SafeVarargs
    public static <T> Stack<T> of(T... values) {
        Stack<T> stack = new Stack<>();

        for (T value : values) {
            stack.push(value);
        }

        return stack;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

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
