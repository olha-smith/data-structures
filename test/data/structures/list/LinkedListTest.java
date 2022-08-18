package data.structures.list;

import data.structures.exceptions.IndexOutOfBoundsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {
    @Test
    public void testAdd_whenEmpty() throws IndexOutOfBoundsException {
        LinkedList<String> list = new LinkedList<>();
        String testString = "Hello";

        list.add(testString);
        String result = list.get(0);

        assertEquals(testString, result);
    }

    @Test
    public void testAdd_whenNotEmpty() throws IndexOutOfBoundsException {
        LinkedList<String> list = new LinkedList<>();
        String testString1 = "Hello";
        String testString2 = "World";

        list.add(testString1);
        list.add(testString2);

        assertEquals(list.get(0), testString1);
        assertEquals(list.get(1), testString2);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 5, 15, 10000})
    public void testSize(int expectedSize) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < expectedSize; i++) {
            list.add(i);
        }

        assertEquals(list.size(), expectedSize);
    }
}
