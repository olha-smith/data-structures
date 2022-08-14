public class ArrayList<T> implements List<T> {
    private static final int INITIAL_CAPACITY = 5;
    // TODO use koef here
    private static final int ADDITIONAL_CAPACITY = 10;
    private int size = 0;
    private int capacity = INITIAL_CAPACITY;
    private Object[] array = new Object[INITIAL_CAPACITY];

    public ArrayList() {}

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean add(T e) {
        if (this.size == this.capacity) {
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
    private void increaseCapacity() {
        this.capacity += ADDITIONAL_CAPACITY;
        Object[] newArray = new Object[this.capacity];
        for (int j = 0; j < this.size; j++) {
            newArray[j] = this.array[j];
        }
        this.array = newArray;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new RuntimeException("Index out of bound");
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
    public T get(int index) {
        return (T) this.array[index];
    }
}
