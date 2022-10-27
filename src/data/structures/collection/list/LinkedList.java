package data.structures.collection.list;

import data.structures.exceptions.IndexOutOfBoundsException;

public class LinkedList<T> extends AbstractList<T> {

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

    private Node<T> head;
    private Node<T> tail;

    @Override
    public boolean add(T e) {
        if (isEmpty()) {
            Node<T> newNode = new Node<T>(e, null, null);
            this.head = newNode;
            this.tail = newNode;
        } else {
            Node<T> lastNode = this.tail;
            Node<T> newNode = new Node<T>(e, null, lastNode);
            this.tail = newNode;
            lastNode.next = newNode;
        }
        ++this.size;

        return true;
    }

    //dont work with empty list
    // dont work with adding to list.size index
    public boolean add(int index, T e) throws IndexOutOfBoundsException {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newNode = new Node<>(e, null, null);
        Node<T> currentNode = this.searchNode(index);

        if (index == 0) {
            newNode.next = currentNode;
            currentNode.prev = newNode;
            this.head = newNode;
        } else {
            Node<T> prevNode = currentNode.prev;
            prevNode.next = newNode;
            currentNode.prev = newNode;
            newNode.prev = prevNode;
            newNode.next = currentNode;
        }
        ++this.size;

        return true;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> nodeToRemove = searchNode(index);
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else if (nodeToRemove == this.head) {
            this.head = nodeToRemove.next;
            nodeToRemove.next.prev = null;
        } else if (nodeToRemove == this.tail) {
            this.tail = nodeToRemove.prev;
            nodeToRemove.prev.next = null;
        } else {
            nodeToRemove.next.prev = nodeToRemove.prev;
            nodeToRemove.prev.next = nodeToRemove.next;
        }
        --this.size;

        return nodeToRemove.data;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        return searchNode(index).data;
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> targetNode = searchNode(index);
        T oldData = targetNode.data;
        targetNode.data = element;

        return oldData;
    }

    private Node<T> searchNode(int index) {
        Node<T> currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }
}
