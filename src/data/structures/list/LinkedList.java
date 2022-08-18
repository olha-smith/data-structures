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

    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    @Override
    public int size() { return this.size; }

    @Override
    public boolean isEmpty() { return this.size == 0; }

    private boolean isOutOfBounds(int index) {
        return index < 0 || index >= this.size;
    }

    @Override
    public boolean add(T e) {
        if (isEmpty()) {
            Node<T> newNode = new Node<T>(e, null, null);
            this.head = newNode;
            this.tail = newNode;
        } else {
            Node<T> prevNode = this.tail;
            Node<T> newNode = new Node<T>(e, null, prevNode);
            this.tail = newNode;
            this.head.next = newNode;
        }
        ++this.size;

        return true;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException {
        return null;
    }
}
