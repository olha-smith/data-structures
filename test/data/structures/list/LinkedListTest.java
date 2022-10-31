package data.structures.list;

import data.structures.collection.list.LinkedList;
import data.structures.exceptions.IndexOutOfBoundsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10})
    public void testAdd_whenNotEmpty(int listSize) throws IndexOutOfBoundsException {
        LinkedList<String> list = new LinkedList<>();
        String[] testElements = {"Hello", "," ," Sweetie", "!", " Happy", " Learning", " Programming", " To", " You", " :3"};

        for (int i = 0; i < listSize; i++) {
            list.add(testElements[i]);
        }

        for (int i = 0; i < listSize; i++) {
            assertEquals(testElements[i], list.get(i));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 5, 9, 10})
    public void testAddByIndex(int index) throws IndexOutOfBoundsException {
        LinkedList<String> list = new LinkedList<>();
        String[] testList = {"Hello", "," ," Sweetie", "!", " Happy", " Learning", " Programming", " To", " You", " :3"};
        String elementToAdd = "New Element";

        for (int i = 0; i < testList.length; i++) {
            list.add(testList[i]);
        }

        list.add(index, elementToAdd);
        assertEquals(elementToAdd, list.get(index));
    }

    @Test
    public void testSize_whenEmpty() {
        LinkedList<Integer> list = createList(0);

        assertEquals(list.size(), 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10})
    public void testSize_whenNotEmpty(int expectedSize) {
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
    public void testRemove_fromTail() throws IndexOutOfBoundsException {
        String[] expectedStrings = {"Hello", "World", "!", "" };
        LinkedList<String> list = createList(expectedStrings);

        for (int i = expectedStrings.length - 1; i >= 0; i-- ) {
            assertEquals(list.remove(i), expectedStrings[i]);
        }
    }

    @Test
    public void testRemove_fromHead() throws IndexOutOfBoundsException {
        String[] expectedStrings = {"Hello", "World", "!", "" };
        LinkedList<String> list = createList(expectedStrings);

        int firstNodeIndex = 0;

        for (int i = 0; i < expectedStrings.length; i++) {
            assertEquals(list.remove(firstNodeIndex), expectedStrings[i]);
        }
    }

    @Test
    public void testRemove_fromMiddle() throws IndexOutOfBoundsException {
        String[] expectedStrings = {"Hello", "World", "!", "" };
        LinkedList<String> list = createList(expectedStrings);

        assertEquals(list.remove(2), expectedStrings[2]);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 5, 9})
    public void testSet(int index) throws IndexOutOfBoundsException {
        String[] expectedStrings = {"Hello", "," ," Sweetie", "!", " Happy", " Learning", " Programming", " To", " You", " :3"};
        LinkedList<String> list = createList(expectedStrings);
        String elementToAdd = "New Element";

        String result = list.set(index, elementToAdd);

        assertEquals(expectedStrings[index], result);
        assertEquals(list.get(index), elementToAdd);
    }

    @Test
    public void testContains() {
        String[] expectedStrings = {"Hello", "World", "!", " " };
        LinkedList<String> list = createList(expectedStrings);

        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.contains(expectedStrings[i]));
        }
    }
}
