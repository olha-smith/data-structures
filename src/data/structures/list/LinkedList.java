package data.structures.list;

import data.structures.exceptions.IndexOutOfBoundsException;

public class LinkedList<T> implements List<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean add(T e) {
        return false;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException {
        return null;
    }
}
