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

    @Test
    public void size_when_emptyList() {
        LinkedList<Integer> list = createList(0);

        assertEquals(list.size(), 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10})
    public void size_when_notEmpty(int expectedSize) {
        LinkedList<Integer> list = createList(expectedSize);

        Integer[] i = {1, 2, 3, 4};
        createList(i);

        assertEquals(list.size(), expectedSize);
    }

    @SuppressWarnings("unchecked")
    private <T> LinkedList<T> createList(int n) {
        LinkedList<T> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add((T) new Object());
        }

        return list;
    }

    private <T> LinkedList<T> createList(T[] values) {
        LinkedList<T> list = new LinkedList<>();

        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }

        return list;
    }


    @Test
    public void testRemove() throws IndexOutOfBoundsException {
        String[] expectedStrings = {"Hello", "World", "!", "" };
        LinkedList<String> list = createList(expectedStrings);

        for (int i = expectedStrings.length - 1; i >= 0; i-- ) {
            assertEquals(list.remove(i), expectedStrings[i]);
        }
    }
}
