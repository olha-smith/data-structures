public interface List<T> {
    int size();
    boolean isEmpty();
    boolean add(T e);
    T remove(int index);
    /**
     * Returns the element at the specified position in this list.
     * @param index of the element to return
     * @return the element at the specified position in this list.
     * @throws IndexOutOfBoundsException – if the index is out of range (index < 0 || index >= size())
     */
    T get(int index);
}
