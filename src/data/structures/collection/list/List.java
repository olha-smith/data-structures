package data.structures.collection.list;

import data.structures.collection.Collection;
import data.structures.exceptions.IndexOutOfBoundsException;

public interface List<T> extends Collection<T> {

    boolean add(T e);

    boolean add(int index, T e) throws IndexOutOfBoundsException;

    T remove(int index) throws IndexOutOfBoundsException;

    T get(int index) throws IndexOutOfBoundsException;

    T set(int index, T element) throws IndexOutOfBoundsException;

    int indexOf(T data);

}
