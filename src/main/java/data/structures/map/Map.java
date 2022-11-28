package data.structures.map;

import data.structures.collection.list.LinkedList;

public interface Map<K, V> {

    boolean clear();

    boolean containsKey(K key);

    boolean containsValue(V value);

    V get(K key);

    boolean isEmpty();

    boolean put(K key, V value);

    boolean remove(K key);

    int size();

    LinkedList<V> values();
}
