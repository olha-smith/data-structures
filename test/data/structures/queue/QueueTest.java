package data.structures.queue;

import data.structures.exceptions.IndexOutOfBoundsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    @Test
    void testEnqueue_whenEmpty() {
        Queue<String> queue = new Queue<>();
        String testString = "Hello";

        String result = queue.enqueue(testString);

        assertEquals(testString, result);
    }

    @Test
    void testDequeue() throws IndexOutOfBoundsException {
        Queue<String> queue = new Queue<>();
        String testString1 = "Hello";
        String testString2 = "World";

        queue.enqueue(testString1);
        queue.enqueue(testString2);
        String result1 = queue.dequeue();
        String result2 = queue.dequeue();

        assertEquals(testString1, result1);
        assertEquals(testString2, result2);
    }

    @Test
    void testFront() throws IndexOutOfBoundsException {
        Queue<String> queue = new Queue<>();
        String testString1 = "Hello";
        String testString2 = "World";

        queue.enqueue(testString1);
        queue.enqueue(testString2);

        assertEquals(testString1, queue.front());
        queue.dequeue();
    }

    @Test
    void testRear() throws IndexOutOfBoundsException {
        Queue<String> queue = new Queue<>();
        String testString1 = "Hello";
        String testString2 = "World";

        queue.enqueue(testString1);
        queue.enqueue(testString2);

        assertEquals(testString2, queue.rear());
        assertEquals(testString1, queue.dequeue());
        assertEquals(testString2, queue.rear());
    }

    @Test
    void testSize() {
        Queue<String> queue = new Queue<>();
        String testString1 = "Hello";
        String testString2 = "World";
        int expectedSize = 2;

        queue.enqueue(testString1);
        queue.enqueue(testString2);

        assertEquals(expectedSize, queue.size());
    }

    @Test
    void testIsEmpty() {
        Queue<String> queue = new Queue<>();
        String testString1 = "Hello";

        assertTrue(queue.isEmpty());

        queue.enqueue(testString1);
        assertFalse(queue.isEmpty());
    }
}
