package data.structures.list;

abstract class AbstractList<T> implements List<T> {

    protected int size = 0;

    @Override
    public int size() { return this.size; }

    @Override
    public boolean isEmpty() { return this.size == 0; }

    protected boolean isOutOfBounds(int index) {
        return index < 0 || index >= this.size;
    }
}
