package data.structures.queue;

import data.structures.exceptions.IndexOutOfBoundsException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DequeTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10})
    public void testInsertLast(int dequeSize) throws IndexOutOfBoundsException {
        Deque<String> deque = new Deque<>();
        String[] testElements = {"Hello", "," ," Sweety", "!", " Happy", " Learning", " Programming", " To", " You", " :3"};

        for (int i = 0; i < dequeSize; i++) {
            deque.insertLast(testElements[i]);
            assertEquals(testElements[i], deque.getRear());
        }
    }
}
