package data.structures.collection;

import data.structures.exceptions.IndexOutOfBoundsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test
    void testPush() {
        Stack<String> stack = new Stack<>();
        String testString = "Hello";

        String result = stack.push(testString);

        assertEquals(testString, result);
    }

    @Test
    void testPop() throws IndexOutOfBoundsException {
        Stack<String> stack = new Stack<>();
        String testString1 = "Hello";
        String testString2 = "World";

        stack.push(testString1);
        stack.push(testString2);

        assertEquals(testString2, stack.pop());
        assertEquals(testString1, stack.pop());
    }

    @Test
    void testTop() throws IndexOutOfBoundsException {
        Stack<String> stack = new Stack<>();
        String testString1 = "Hello";
        String testString2 = "World";

        stack.push(testString1);
        stack.push(testString2);

        assertEquals(testString2, stack.top());
    }

    @Test
    void testSize() {
        Stack<String> stack = new Stack<>();
        String testString1 = "Hello";
        String testString2 = "World";
        int expectedSize = 2;

        stack.push(testString1);
        stack.push(testString2);

        assertEquals(expectedSize, stack.size());
    }

    @Test
    void testIsEmpty() {
        Stack<String> stack = new Stack<>();
        String testString1 = "Hello";

        assertTrue(stack.isEmpty());

        stack.push(testString1);
        assertFalse(stack.isEmpty());
    }
}
