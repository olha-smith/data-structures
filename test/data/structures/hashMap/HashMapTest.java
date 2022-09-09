package data.structures.hashMap;

import data.structures.exceptions.IndexOutOfBoundsException;
import data.structures.list.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
