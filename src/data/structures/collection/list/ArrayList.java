package data.structures.collection.list;

import data.structures.exceptions.IndexOutOfBoundsException;

//FIXME one == two -> one.equals(two)
public class ArrayList<T> implements List<T> {
    static final int INITIAL_CAPACITY = 5;
    static final float LOAD_FACTOR = 0.6f;
    static final float INCREASE_FACTOR = 1.3f;

    private int capacity = INITIAL_CAPACITY;
    @SuppressWarnings("unchecked") private T[] array = (T[]) new Object[INITIAL_CAPACITY];

    protected int size = 0;

    @Override
    public int size() { return this.size; }

    @Override
    public boolean isEmpty() { return this.size == 0; }

    @Override
    public boolean contains(T data) {
        for (int i = 0; i < size; i++) {
            if (this.array[i] == data) {
                return true;
            }
        }
        return false;
    }

    protected boolean isOutOfBounds(int index) {
        return index < 0 || index >= this.size;
    }

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

    @Override
    public boolean add(int index, T e) throws IndexOutOfBoundsException {
        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (isOverloaded()) {
            increaseCapacity();
        }

        if (index != this.size) {
            shiftFrom(index);
        }

        this.array[index] = e;
        this.size++;

        return true;
    }

    private void shiftFrom(int index) {
        for (int i = this.size; i >= index; i--) {
            this.array[i + 1] = this.array[i];
        }
    }

    private boolean isOverloaded() {
        return (float) this.size / this.capacity > LOAD_FACTOR;
    }

    private void increaseCapacity() {
        this.capacity *= INCREASE_FACTOR;
        @SuppressWarnings("unchecked") T[] newArray = (T[]) new Object[this.capacity];
        for (int j = 0; j < this.size; j++) {
            newArray[j] = this.array[j];
        }
        this.array = newArray;
    }

    @Override
    public int indexOf(T data) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i].equals(data)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        int lastElementIndex = this.size - 1;
        T removedElement = this.array[index];

        for (int i = index; i < lastElementIndex; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.array[lastElementIndex] = null;
        --this.size;

        return removedElement;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        return this.array[index];
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        T replacedElement = this.array[index];
        this.array[index] = element;

        return replacedElement;
    }

    int getCapacity() {
        return capacity;
    }
}
