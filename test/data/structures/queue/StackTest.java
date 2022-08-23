package data.structures.queue;

import data.structures.exceptions.IndexOutOfBoundsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StackTest {
    @Test
    public void testPush() {
        Stack<String> stack = new Stack<>();
        String testString = "Hello";

        String result = stack.push(testString);

        assertEquals(testString, result);
    }

    @Test
    public void testPop() throws IndexOutOfBoundsException {
        Stack<String> stack = new Stack<>();
        String testString1 = "Hello";
        String testString2 = "World";

        stack.push(testString1);
        stack.push(testString2);

        assertEquals(testString2, stack.pop());
        assertEquals(testString1, stack.pop());
    }

    @Test
    public void testTop() throws IndexOutOfBoundsException {
        Stack<String> stack = new Stack<>();
        String testString1 = "Hello";
        String testString2 = "World";

        stack.push(testString1);
        stack.push(testString2);

        assertEquals(testString2, stack.top());
    }

    @Test
    public void testSize() {
        Stack<String> stack = new Stack<>();
        String testString1 = "Hello";
        String testString2 = "World";
        int expectedSize = 2;

        stack.push(testString1);
        stack.push(testString2);

        assertEquals(expectedSize, stack.size());
    }

    @Test
    public void testIsEmpty() {
        Stack<String> stack = new Stack<>();
        String testString1 = "Hello";

        assertTrue(stack.isEmpty());

        stack.push(testString1);
        assertFalse(stack.isEmpty());
    }
}
