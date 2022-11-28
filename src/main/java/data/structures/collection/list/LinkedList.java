package data.structures.collection.list;

import data.structures.collection.Iterator;
import data.structures.exceptions.IndexOutOfBoundsException;

public class LinkedList<T> implements List<T> {

    private int size = 0;

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

    @SafeVarargs
    public static <T> LinkedList<T> of(T... values) {
        LinkedList<T> list = new LinkedList<>();

        for (T value : values) {
            list.add(value);
        }

        return list;
    }

    public int size() { return this.size; }

    public boolean isEmpty() { return this.size == 0; }

    @Override
    public boolean contains(T data) {
        return searchNode(data) != null;
    }

    protected boolean isOutOfBounds(int index) {
        return index < 0 || index >= this.size;
    }

    @Override
    public boolean add(T e) {
        Node<T> newNode = new Node<>(e, null, null);

        if (isEmpty()) {
            this.head = newNode;
        } else {
            Node<T> lastNode = this.tail;
            newNode.prev = lastNode;
            lastNode.next = newNode;
        }

        this.tail = newNode;
        ++this.size;

        return true;
    }

    @Override
    public boolean add(int index, T e) throws IndexOutOfBoundsException {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> newNode = new Node<>(e, null, null);

        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else if (index == this.size) {
            Node<T> lastNode = this.tail;
            this.tail = newNode;
            newNode.prev = lastNode;
            lastNode.next = newNode;
        } else if (index == 0) {
            Node<T> firstNode = this.head;
            this.head = newNode;
            newNode.next = firstNode;
            firstNode.prev = newNode;
        } else {
            Node<T> currentNode = searchNode(index);
            Node<T> prevNode = currentNode.prev;

            newNode.prev = prevNode;
            newNode.next = currentNode;
            prevNode.next = newNode;
            currentNode.prev = newNode;
        }
        ++size;
        return true;
    }


    @Override
    public boolean remove(T e) {
        //TODO Implement
        return false;
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
    public int indexOf(T data) {
        Node<T> currentNode = head;
        int i = 0;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return i;
            }
            currentNode = currentNode.next;
            ++i;
        }

        return -1;
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

    private Node<T> searchNode(T data) {
        Node<T> currentNode = this.head;

        for (int i = 0; i < this.size; i++) {
            if (currentNode.data == data) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    class LinkedListIterator implements Iterator<T> {

        private int nextElement = 0;

        @Override
        public boolean hasNext() {
            return nextElement < size;
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                try {
                    ++nextElement;
                    return LinkedList.this.get(nextElement);
                } catch (IndexOutOfBoundsException e) {
                    throw new RuntimeException(e);
                }
            }

            return null;
        }
    }
}
