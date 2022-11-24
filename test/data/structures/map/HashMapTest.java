package data.structures.map;

import org.junit.jupiter.api.Test;

import static data.structures.map.HashMap.Pair;
import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    @Test
    void Clear_WhenNotEmpty_ShouldRemoveAllKeysAndKeepCapacity() {
        HashMap<Integer, String> hashMap = HashMap.of(Pair.of(1, "first"));
        Integer expectedCapacity = hashMap.buckets.length;

        hashMap.clear();

        assertTrue(hashMap.isEmpty());
        assertEquals(expectedCapacity, hashMap.buckets.length);
    }

    @Test
    void ContainsKey_WhenKeyInHashMap_ShouldReturnTrue() {
        Integer key = 1;
        HashMap<Integer, String> hashMap = HashMap.of(Pair.of(key, "first"));

        assertTrue(hashMap.containsKey(key));
    }

    @Test
    void ContainsKey_WhenKeyNotInHashMap_ShouldReturnFalse() {
        Integer key = 1;
        HashMap<Integer, String> hashMap = new HashMap<>();

        assertFalse(hashMap.containsKey(key));
    }

    @Test
    void ContainsValue_WhenValueInHashMap_ShouldReturnTrue() {
        String value = "first";
        HashMap<Integer, String> hashMap = HashMap.of(Pair.of(1, value));

        assertTrue(hashMap.containsValue(value));
    }

    @Test
    void ContainsValue_WhenValueNotInHashMap_ShouldReturnFalse() {
        String value = "first";
        HashMap<Integer, String> hashMap = new HashMap<>();

        assertFalse(hashMap.containsValue(value));
    }

    @Test
    void Get_WhenHasSuchPair_ShouldReturnValue() {
        String value = "first";
        Integer key = 1;
        HashMap<Integer, String> hashMap = HashMap.of(Pair.of(key, value));

        assertEquals(value, hashMap.get(key));
    }

    @Test
    void Put_WhenEmpty_ShouldPutPairInHashMap() {
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "first");

        assertTrue(hashMap.containsKey(1));
        assertTrue(hashMap.containsValue("first"));
        assertEquals(1, hashMap.size());
    }

    @Test
    void Put_WhenAddKeysWithSameHashCode_ShouldCreateNewPairForEach() {
        String key1 = "FB";
        String key2 = "Ea";
        HashMap<String, String> hashMap = HashMap.of(Pair.of(key1, "first"));

        hashMap.put(key2, "second");

        assertEquals(key1.hashCode(), key2.hashCode());
        assertTrue(hashMap.containsValue("first"));
        assertTrue(hashMap.containsValue("second"));
    }

    @Test
    void Put_WhenAddSameKey_ShouldReplaceValue() {
        Integer key = 1;
        String newValue = "New";
        HashMap<Integer, String> hashMap = HashMap.of(Pair.of(key, "first"));

        hashMap.put(key, newValue);

        assertEquals(newValue, hashMap.get(key));
        assertEquals(1, hashMap.size());
    }

    @Test
    void Remove_WhenNotEmpty_ShouldRemovePair() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "first");

        hashMap.remove(1);

        assertFalse(hashMap.containsKey(1));
        assertFalse(hashMap.containsValue("first"));
    }

    @Test
    void Size_WhenAddElement_ShouldIncreaseSize() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        Integer[] keys = {0, 1, 30, 2700};
        String value = "value";
        Integer expectedSize = 0;

        for (Integer key : keys) {
            hashMap.put(key, value);
            expectedSize = expectedSize + 1;

            assertEquals(expectedSize, hashMap.size());
        }
    }

    @Test
    void Size_WhenRemoveElement_ShouldDecreaseSize() {
        HashMap<Integer, String> hashMap = HashMap.of(Pair.of(0, "0"), Pair.of( 1, "1"), Pair.of(30, "30"), Pair.of(2700, "2700"));
        Integer[] keys = {0, 1, 30, 2700};
        Integer expectedSize = hashMap.size();

        for (Integer key : keys) {
            hashMap.remove(key);
            expectedSize = expectedSize - 1;

            assertEquals(expectedSize, hashMap.size());
        }
    }

    @Test
    void Values_WhenNotEmpty_ShouldContainThatValues() {
        String[] values = {"Hello", "World"};
        HashMap<Integer, String> hashMap = HashMap.of(Pair.of(0, values[0]), Pair.of( 1, values[1]));

        assertTrue(hashMap.values().contains(values[0]));
        assertTrue(hashMap.values().contains(values[1]));
    }
}