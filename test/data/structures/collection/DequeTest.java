package data.structures.collection;

import data.structures.exceptions.IndexOutOfBoundsException;
import data.structures.utils.Builders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 30, 2700})
    void InsertLast_WhenNotEmpty_ShouldAddElementToTail(int elementToAdd) throws IndexOutOfBoundsException {
        Deque<Integer> deque = Deque.of(0);

        deque.insertLast(elementToAdd);

        assertEquals(deque.getRear(), elementToAdd);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 30, 2700})
    void InsertFront_WhenNotEmpty_ShouldAddElementToFront(int elementToAdd) throws IndexOutOfBoundsException {
        Deque<Integer> deque = Deque.of(0);

        deque.insertFront(elementToAdd);

        assertEquals(deque.getFront(), elementToAdd);
    }

    @Test
    void DeleteLast_WhenNotEmpty_ShouldDeleteLastElement() throws IndexOutOfBoundsException {
        Deque<Integer> deque = Deque.of(0, 1, 30, 2700);

        while (deque.size() > 0) {
            assertEquals(deque.getRear(), deque.deleteLast());
        }
    }

    @Test
    void DeleteFront_WhenNotEmpty_ShouldDeleteFirstElement() throws IndexOutOfBoundsException {
        Deque<Integer> deque = Deque.of(0, 1, 30, 2700);

        while (deque.size() > 0) {
            assertEquals(deque.getFront(), deque.deleteFront());
        }
    }

    @Test
    void GetFront_WhenNotEmpty_ShouldReturnFirstElement() throws IndexOutOfBoundsException {
        String firstElement = "Hello";
        Deque<String> deque = Deque.of(firstElement, "World", "!", "");

        assertEquals(firstElement, deque.getFront());
    }

    @Test
    void GetRear_WhenNotEmpty_ShouldReturnLastElement() throws IndexOutOfBoundsException {
        String lastElement = "last";
        Deque<String> deque = Deque.of("Hello", "World", "!", "", lastElement);

        assertEquals(lastElement, deque.getRear());
    }

    @Test
    void Size_WhenAddElement_ShouldIncreaseSize() {
        int expectedSize = 5;
        Deque<Integer> deque = Deque.of(Builders.arrayOfNumbers(5));

        assertEquals(expectedSize, deque.size());
    }

    @Test
    void Size_WhenRemoveElement_ShouldDecreaseSize() throws IndexOutOfBoundsException {
        int expectedSize = 5;
        Deque<Integer> deque = Deque.of(Builders.arrayOfNumbers(5));

        deque.deleteLast();

        assertEquals(expectedSize - 1, deque.size());
    }

    @Test
    void IsEmpty_WhenEmpty_ShouldReturnTrue() {
        Deque<String> deque = new Deque<>();

        assertTrue(deque.isEmpty());
    }

    @Test
    void IsEmpty_WhenNotEmpty_ShouldReturnFalse() {
        Deque<String> deque = Deque.of("Not Empty!");

        assertFalse(deque.isEmpty());
    }
}
