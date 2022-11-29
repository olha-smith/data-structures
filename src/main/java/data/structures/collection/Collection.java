package data.structures.collection;

public interface Collection<T> extends Iterable<T> {

    boolean add(T e);

    boolean remove(T e);

    int size();

    boolean isEmpty();

    boolean contains(T data);

}
