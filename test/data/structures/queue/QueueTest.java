package data.structures.queue;

import data.structures.exceptions.IndexOutOfBoundsException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTest {
    @Test
    public void testEnqueue_whenEmpty() {
        Queue<String> queue= new Queue<>();
        String testString = "Hello";

        String result = queue.enqueue(testString);

        assertEquals(testString, result);
    }

    @Test
    public void testDequeue() throws IndexOutOfBoundsException {
        Queue<String> queue= new Queue<>();
        String testString1 = "Hello";
        String testString2 = "World";

        queue.enqueue(testString1);
        queue.enqueue(testString2);
        String result1 = queue.dequeue();
        String result2 = queue.dequeue();

        assertEquals(testString2, result1);
        assertEquals(testString1, result2);
    }

    @Test
    public void testFront() throws IndexOutOfBoundsException {
        Queue<String> queue= new Queue<>();
        String testString1 = "Hello";
        String testString2 = "World";

        queue.enqueue(testString1);
        queue.enqueue(testString2);

        assertEquals(testString1, queue.front());
        queue.dequeue();
        assertEquals(testString2, queue.front());
    }
}
