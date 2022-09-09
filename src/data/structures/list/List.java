package data.structures.list;

import data.structures.exceptions.IndexOutOfBoundsException;

public interface List<T> {

    int size();

    boolean isEmpty();

    boolean add(T e);

    boolean add(int index, T e) throws IndexOutOfBoundsException;

    T remove(int index) throws IndexOutOfBoundsException;

    T get(int index) throws IndexOutOfBoundsException;

    T set(int index, T element) throws IndexOutOfBoundsException;
}
