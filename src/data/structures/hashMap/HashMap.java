package data.structures.hashMap;

import data.structures.exceptions.IndexOutOfBoundsException;
import data.structures.list.LinkedList;

public class HashMap<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private final LinkedList<Pair<K, LinkedList<V>>>[] buckets = new LinkedList[INITIAL_CAPACITY];

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

    V removeValue(K key, V value) throws IndexOutOfBoundsException {
        //receive the value, that you have to delete
        LinkedList<V> values = this.get(key);
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) == value) {
                return values.remove(i);
            }
        }

        return null;
    }

    Pair<K, LinkedList<V>> removePair(K key) throws IndexOutOfBoundsException {
        LinkedList<Pair<K, LinkedList<V>>> pairs = buckets[getBucketIndex(key)];
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).key == key) {
                return pairs.remove(i);
            }
        }
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
}
