package data.structures.queue;

import data.structures.collection.Deque;
import data.structures.exceptions.IndexOutOfBoundsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10})
    void testInsertLast(int dequeSize) throws IndexOutOfBoundsException {
        Deque<String> deque = new Deque<>();
        String[] testElements = {"Hello", "," ," Sweety", "!", " Happy", " Learning", " Programming", " To", " You", " :3"};

        for (int i = 0; i < dequeSize; i++) {
            deque.insertLast(testElements[i]);
            assertEquals(testElements[i], deque.getRear());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10})
    void testInsertFront(int dequeSize) throws IndexOutOfBoundsException {
        Deque<String> deque = new Deque<>();
        String[] testElements = {"Hello", "," ," Sweety", "!", " Happy", " Learning", " Programming", " To", " You", " :3"};
        deque.insertLast("");

        for (int i = 0; i < dequeSize; i++) {
            deque.insertFront(testElements[i]);
            assertEquals(testElements[i], deque.getFront());
            assertEquals(i + 1, deque.size() - 1);
        }
    }

    @Test
    void testDeleteLast() throws IndexOutOfBoundsException {
        Deque<String> deque = new Deque<>();
        String[] testElements = {"Hello", "," ," Sweety", "!", " Happy", " Learning", " Programming", " To", " You", " :3"};

        for (int i = 0; i < testElements.length; i++) {
            deque.insertLast(testElements[i]);
        }

        for (int i = testElements.length - 1; i >= 0; i--) {
            assertEquals(testElements[i], deque.deleteLast());
        }
    }

    @Test
    void testDeleteFront() throws IndexOutOfBoundsException {
        Deque<String> deque = new Deque<>();
        String[] testElements = {"Hello", "," ," Sweety", "!", " Happy", " Learning", " Programming", " To", " You", " :3"};

        for (int i = 0; i < testElements.length; i++) {
            deque.insertLast(testElements[i]);
        }

        for (int i = 0; deque.size() > 0; i++) {
            assertEquals(testElements[i], deque.deleteFront());
        }
    }

    @Test
    void testIsEmpty() {
        Deque<String> deque = new Deque<>();
        String testString = "Hello";
        assertTrue(deque.isEmpty());

        deque.insertLast(testString);
        assertFalse(deque.isEmpty());
    }
}
