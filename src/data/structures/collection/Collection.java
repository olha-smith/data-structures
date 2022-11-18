package data.structures.collection;

public interface Collection<T> extends Iterable<T> {

    int size();

    boolean isEmpty();

    boolean contains(T data);

}
