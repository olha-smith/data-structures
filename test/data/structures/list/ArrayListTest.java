package data.structures.list;

import data.structures.exceptions.IndexOutOfBoundsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayListTest {

    private static final int INITIAL_CAPACITY = 5;

    @Test
    public void testAdd_whenEmpty() throws IndexOutOfBoundsException {
        ArrayList<String> list = new ArrayList<>();
        String testString = "Hello";

        list.add(testString);
        String result = list.get(0);

        assertEquals(result, testString);
    }

    @Test
    public void testAdd_whenNotEmpty() throws IndexOutOfBoundsException {
        ArrayList<String> list = new ArrayList<>();
        String testString1 = "Hello";
        String testString2 = "World";

        list.add(testString1);
        list.add(testString2);

        assertEquals(list.get(0), testString1);
        assertEquals(list.get(1), testString2);
    }

    @Test
    public void testAdd_whenFull() throws IndexOutOfBoundsException {
        ArrayList<String> list = new ArrayList<>();
        String[] expectedStrings = {"Hello", "World", "!", "I", "like", "beer"};

        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            list.add(expectedStrings[i]);
        }

        list.add(expectedStrings[INITIAL_CAPACITY]);

        for (int i = 0; i <= INITIAL_CAPACITY; i++) {
            assertEquals(list.get(i), expectedStrings[i]);
        }
    }

    @Test
    public void testAdd_withInteger() throws IndexOutOfBoundsException {
        ArrayList<Integer> list = new ArrayList<>();
        int testInt = 1;

        list.add(testInt);
        Integer result = list.get(0);

        assertEquals(result,  testInt);
    }

    @Test
    public void testSize_whenEmpty() {
        ArrayList<String> list = new ArrayList<>();
        int testInt = 0;

        int result = list.size();

        assertEquals(result, testInt);
    }

    @Test
    public void testSize_whenNotEmpty() {
        ArrayList<String> list = new ArrayList<>();
        int expectedSize = 2;
        String testString1 = "Hello";
        String testString2 = "World";

        list.add(testString1);
        list.add(testString2);
        int result = list.size();

        assertEquals(result, expectedSize);
    }

    @Test
    public void testRemove_happyPath() throws IndexOutOfBoundsException {
        ArrayList<String> list = new ArrayList<>();
        String testString1 = "Hello";
        String testString2 = "World";

        list.add(testString1);
        list.add(testString2);
        assertEquals(list.size(), 2);

        String result1 = list.remove(1);
        assertEquals(list.size(), 1);
        String result2 = list.remove(0);
        assertEquals(list.size(), 0);
        assertEquals(result1, testString2);
        assertEquals(result2, testString1);
    }

    @Test
    public void testRemove_whenOutOfBounds() {
        ArrayList<String> list = new ArrayList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    public void testGet_whenOutOfBounds() {
        ArrayList<String> list = new ArrayList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void testSet_happyPath() throws IndexOutOfBoundsException {
        ArrayList<String> list = new ArrayList<>();
        String testString1 = "Hello";
        String testString2 = "World";

        list.add(testString1);
        String replacedString = list.set(0, testString2);
        String result = list.get(0);

        assertEquals(replacedString, testString1);
        assertEquals(result, testString2);
    }

}