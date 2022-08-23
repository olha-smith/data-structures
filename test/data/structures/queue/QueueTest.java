package data.structures.queue;

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
}
