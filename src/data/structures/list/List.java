package data.structures.list;

import data.structures.exceptions.IndexOutOfBoundsException;

public interface List<T> {
    int size();
    boolean isEmpty();
    boolean add(T e);
    T remove(int index) throws IndexOutOfBoundsException;
    /**
     * Returns the element at the specified position in this list.
     * @param index of the element to return
     * @return the element at the specified position in this list.
     * @throws IndexOutOfBoundsException – if the index is out of range (index < 0 || index >= size())
     */
    T get(int index) throws IndexOutOfBoundsException;

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException – if the index is out of range (index < 0 || index >= size())
     */
    T set(int index, T element) throws IndexOutOfBoundsException;
}
