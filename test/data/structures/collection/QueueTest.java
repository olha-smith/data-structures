package data.structures.collection;

import data.structures.exceptions.IndexOutOfBoundsException;
import data.structures.utils.Builders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    @Test
    void Enqueue_WhenEmpty_ShouldAddElement() {
        Queue<String> queue = new Queue<>();
        String elementToAdd = "Hello";

        assertEquals(elementToAdd, queue.enqueue(elementToAdd));
    }

    @ParameterizedTest
    @ValueSource(strings = {"World", "!", ""})
    void Enqueue_WhenNotEmpty_ShouldAddElementToTail(String elementToAdd) throws IndexOutOfBoundsException {
        Queue<String> queue = Queue.of("Hello");

        queue.enqueue(elementToAdd);

        assertEquals(elementToAdd, queue.rear());
    }

    @Test
    void Dequeue_WhenNotEmpty_ShouldRemoveFirstElement() throws IndexOutOfBoundsException {
        Queue<String> queue = Queue.of("Hello", "World", "!", "");

        for (int i = queue.size(); i > 0; i--) {
            assertEquals(queue.front(), queue.dequeue());
        }
    }

    @Test
    void Front_WhenNotEmpty_ShouldReturnFirstElement() throws IndexOutOfBoundsException {
        String firstElement = "Hello";
        Queue<String> queue = Queue.of(firstElement, "World", "!", "");

        assertEquals(firstElement, queue.front());
    }

    @Test
    void Rear_WhenNotEmpty_ShouldReturnLastElement() throws IndexOutOfBoundsException {
        String lastElement = "last";
        Queue<String> queue = Queue.of("Hello", "World", "!", lastElement);

        assertEquals(lastElement, queue.rear());
    }

    @Test
    void Size_WhenAddElement_ShouldIncreaseSize() {
        int expectedSize = 5;
        Queue<Integer> queue = Queue.of(Builders.arrayOfNumbers(5));

        assertEquals(expectedSize, queue.size());
    }

    @Test
    void Size_WhenRemoveElement_ShouldDecreaseSize() throws IndexOutOfBoundsException {
        int expectedSize = 5;
        Queue<Integer> queue = Queue.of(Builders.arrayOfNumbers(5));

        queue.dequeue();

        assertEquals(expectedSize - 1, queue.size());
    }

    @Test
    void IsEmpty_WhenEmpty_ShouldReturnTrue() {
        Queue<String> queue = new Queue<>();

        assertTrue(queue.isEmpty());
    }

    @Test
    void IsEmpty_WhenNotEmpty_ShouldReturnFalse() {
        Queue<String> queue = Queue.of("Not Empty!");

        assertFalse(queue.isEmpty());
    }
}
