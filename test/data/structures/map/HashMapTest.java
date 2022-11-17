package data.structures.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HashMapTest {

    @Test
    void clear() {
    }

    @Test
    void containsKey() {
    }

    @Test
    void containsValue() {
    }

    @Test
    void get() {
    }

    @Test
    void put() {
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "first");

        assertTrue(hashMap.containsKey(1));
        assertTrue(hashMap.containsValue("first"));
    }

    @Test
    void remove() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "first");

        hashMap.remove(1);

        assertFalse(hashMap.containsKey(1));
        assertFalse(hashMap.containsValue("first"));
    }

    @Test
    void values() {
    }
}