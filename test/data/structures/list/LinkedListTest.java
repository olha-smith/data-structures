package data.structures.list;

import data.structures.exceptions.IndexOutOfBoundsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {
    @Test
    public void testAdd_whenEmpty() throws IndexOutOfBoundsException {
        //test add and get
        LinkedList<String> list = new LinkedList<>();
        String testString = "Hello";

        list.add(testString);
        String result = list.get(0);

        assertEquals(testString, result);
    }
}
