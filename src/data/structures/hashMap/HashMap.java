package data.structures.hashMap;

import data.structures.exceptions.IndexOutOfBoundsException;
import data.structures.list.LinkedList;

public class HashMap<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    LinkedList<Pair<K, LinkedList<V>>>[] buckets = new LinkedList[INITIAL_CAPACITY];

    boolean put(K key, V value) throws IndexOutOfBoundsException {
        int index = getBucketIndex(key);

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        LinkedList<Pair<K, LinkedList<V>>> pairs = buckets[index];

        for (int i = 0; i < pairs.size(); i++) {
            Pair<K, LinkedList<V>> currentPair = pairs.get(i);
            if (currentPair.key == key) {
                currentPair.value.add(value);
                return true;
            }
        }

        LinkedList<V> values = new LinkedList<>();
        values.add(value);
        pairs.add(new Pair<>(key, values));

        return true;
    }

    V removeValue(Pair<K, V> pair) {
        return null;
    }

    Pair<K, V> removePair(K key) {
        return null;
    }

    LinkedList<V> get(K key) throws IndexOutOfBoundsException {
        LinkedList<Pair<K, LinkedList<V>>> pairs = buckets[getBucketIndex(key)];

        for (int i = 0; i < pairs.size(); i++) {
            Pair<K, LinkedList<V>> currentPair = pairs.get(i);
            if (currentPair.key == key) {
                return currentPair.value;
            }
        }

        return null;
    }

    boolean isEquals(Pair<K, V> pair1, Pair<K, V> pair2) {
        return false;
    }

    private int getHash(String key) {
        int result = 1;
        for (int i = 0; i < key.length(); i++) {
            result += key.charAt(i) * (i + 1);
        }
        return result;
    }

    private int getBucketIndex(K key) {
        int hash = getHash(key.toString());
        return hash % buckets.length;
    }

    int size() {
        return 0;
    }

    boolean isEmpty() {
        return false;
    }
}
