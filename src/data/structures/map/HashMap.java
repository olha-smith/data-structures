package data.structures.map;

import data.structures.collection.list.LinkedList;
import data.structures.exceptions.IndexOutOfBoundsException;

public class HashMap<K, V> implements Map<K, V> {

    private static final int INITIAL_CAPACITY = 10;
    private int NUMBER_OF_BUCKETS = INITIAL_CAPACITY;
    private int size = 0;

    @SuppressWarnings("unchecked")
    LinkedList<Pair<K, V>>[] buckets = (LinkedList<Pair<K, V>>[]) new LinkedList[INITIAL_CAPACITY];

    @Override
    public boolean clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
        return true;
    }

    @Override
    public boolean containsKey(K key) {
        return getPair(key) != null;
    }

    @Override
    public boolean containsValue(V value) {
        for (LinkedList<Pair<K, V>> bucket : buckets) {
            for (int i = 0; bucket != null && i < bucket.size(); i++) {
                try {
                    if (bucket.get(i).value.equals(value)) {
                        return true;
                    }
                } catch (IndexOutOfBoundsException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return false;
    }

    @Override
    public V get(K key) {
        Pair<K, V> pair = getPair(key);
        return pair == null ? null : pair.value;
    }

    private Pair<K, V> getPair(K key) {
        LinkedList<Pair<K, V>> bucket = buckets[key.hashCode() % NUMBER_OF_BUCKETS];

        for (int i = 0; bucket != null && i < bucket.size(); i++) {
            Pair<K, V> currentPair;
            try {
                currentPair = bucket.get(i);
            } catch (IndexOutOfBoundsException e) {
                throw new RuntimeException(e);
            }
            if (currentPair.key.equals(key)) {
                return currentPair;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean put(K key, V value) {
        int bucketIndex = key.hashCode() % NUMBER_OF_BUCKETS;
        LinkedList<Pair<K, V>> bucket = buckets[bucketIndex];

        if (bucket != null) {
            for (int i = 0; i < bucket.size(); i++) {
                try {
                    if (bucket.get(i).key.equals(key)) {
                        bucket.get(i).value = value;
                        return true;
                    }
                } catch (IndexOutOfBoundsException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            buckets[bucketIndex] = new LinkedList<>();
        }
        buckets[bucketIndex].add(new Pair<>(key, value));

        return true;
    }

    @Override
    public boolean remove(K key) {
        LinkedList<Pair<K, V>> bucket = buckets[key.hashCode() % NUMBER_OF_BUCKETS];

        for (int i = 0; bucket != null && i < bucket.size(); i++) {
            try {
                if (bucket.get(i).key.equals(key)) {
                    bucket.remove(i);
                    return true;
                }
            } catch (IndexOutOfBoundsException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public LinkedList<V> values() {
        LinkedList<V> list = new LinkedList<>();

        for (LinkedList<Pair<K, V>> bucket : buckets) {
            for (int i = 0; i < bucket.size(); i++) {
                try {
                    list.add(bucket.get(i).value);
                } catch (IndexOutOfBoundsException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return list;
    }

    static class Pair<K, V> {
        K key;
        V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
