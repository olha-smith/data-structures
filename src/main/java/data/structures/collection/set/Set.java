package data.structures.collection.set;

import data.structures.collection.Collection;

public interface Set<T> extends Collection<T> {

    boolean add(T e);

    boolean remove(T e);
}
