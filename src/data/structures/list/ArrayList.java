package data.structures.list;

import data.structures.exceptions.IndexOutOfBoundsException;

public class ArrayList<T> implements List<T> {
    private static final int INITIAL_CAPACITY = 5;
    private static final float LOAD_FACTOR = 0.6f;
    private static final float INCREASE_FACTOR = 1.3f;

    private int size = 0;
    private int capacity = INITIAL_CAPACITY;
    private Object[] array = new Object[INITIAL_CAPACITY];

    public ArrayList() {}

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() { return this.size == 0; }

    @Override
    public boolean add(T e) {
        if (isOverloaded()) {
            increaseCapacity();
        }

        for (int i = 0; i < this.capacity; i++) {
            if (this.array[i] == null) {
                this.array[i] = e;
                this.size++;
                break;
            }
        }

        return true;
    }
    private boolean isOverloaded() {
        return (float) this.size / this.capacity > LOAD_FACTOR;
    }
    private void increaseCapacity() {
        this.capacity *= INCREASE_FACTOR;
        Object[] newArray = new Object[this.capacity];
        for (int j = 0; j < this.size; j++) {
            newArray[j] = this.array[j];
        }
        this.array = newArray;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) throws IndexOutOfBoundsException {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        int lastElementIndex = this.size - 1;
        T removedElement = (T) this.array[index];

        for (int i = index; i < lastElementIndex; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.array[lastElementIndex] = null;
        --this.size;

        return removedElement;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) throws IndexOutOfBoundsException {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        return (T) this.array[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T set(int index, T element) throws IndexOutOfBoundsException {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        T replacedElement = (T) this.array[index];
        this.array[index] = element;

        return replacedElement;
    }

    private boolean isOutOfBounds(int index) {
        return index < 0 || index >= this.size;
    }
}
