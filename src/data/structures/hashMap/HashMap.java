package data.structures.hashMap;

public interface HashMap<K, V> {
    boolean put(K key, V value);
    V removeValue(Pair<K, V> pair);
    Pair<K, V> removePair(K key);
    Pair<K, V> get(K key);
    boolean isEquals(Pair<K, V> pair1, Pair<K, V> pair2);
    int hashCodeIndex(K key);
    int size();
    boolean isEmpty();
}
