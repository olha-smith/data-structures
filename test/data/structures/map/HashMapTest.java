package data.structures.map;

import data.structures.exceptions.IndexOutOfBoundsException;
import data.structures.collection.list.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {
    @Test
    public void putTest() throws IndexOutOfBoundsException {
        HashMap<String, String> hashMap = new HashMap<>();
        String testKey = "Nickname";
        String testValue = "Mobster";

        boolean result = hashMap.put(testKey, testValue);
        assertTrue(result);

        LinkedList<String> values = hashMap.get(testKey);

        assertEquals(testValue, values.get(values.size() - 1));
    }

    @Test
    public void removeValueTest() throws IndexOutOfBoundsException {
        HashMap<String, String> hashMap = new HashMap<>();
        String testKey = "Nickname";
        String testValue1 = "Mobster";
        String testValue2 = "Lobster";

        hashMap.put(testKey, testValue1);
        hashMap.put(testKey, testValue2);

        assertEquals(testValue2, hashMap.removeValue(testKey, testValue2));
    }

    @Test
    public void removePairTest() throws IndexOutOfBoundsException {
        HashMap<String, String> hashMap = new HashMap<>();
        String testKey = "Nickname";
        String testValue = "Mobster";

        hashMap.put(testKey, testValue);
        hashMap.get(testKey);
        assertNotNull(hashMap.get(testKey));

        hashMap.removePair(testKey);
        assertNull(hashMap.get(testKey));
    }
}
