package data.structures.collection;

import data.structures.exceptions.IndexOutOfBoundsException;
import data.structures.utils.Builders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test
    void Push_WhenEmpty_ShouldAddElement() {
        Stack<String> stack = new Stack<>();
        String elementToAdd = "Hello";

        assertEquals(elementToAdd, stack.push(elementToAdd));
    }

    @ParameterizedTest
    @ValueSource(strings = {"World", "!", ""})
    void Push_WhenNotEmpty_ShouldAddElementToTail(String elementToAdd) throws IndexOutOfBoundsException {
        Stack<String> stack = Stack.of("Hello");

        stack.push(elementToAdd);

        assertEquals(elementToAdd, stack.top());
    }

    @Test
    void Pop_WhenNotEmpty_ShouldRemoveElementFromTail() throws IndexOutOfBoundsException {
        Stack<Integer> stack = Stack.of(2700, 30, 1, 0);

        while (stack.size() > 0) {
            assertEquals(stack.top(), stack.pop());
        }
    }

    @Test
    void Top_WhenNotEmpty_ShouldReturnLastElement() throws IndexOutOfBoundsException {
        String lastElement = "last";
        Stack<String> stack = Stack.of("Hello", "World", "!", lastElement);

        assertEquals(lastElement, stack.top());
    }

    @Test
    void Size_WhenAddElement_ShouldIncreaseSize() {
        int expectedSize = 5;
        Stack<Integer> stack = Stack.of(Builders.arrayOfNumbers(expectedSize));

        assertEquals(expectedSize, stack.size());
    }

    @Test
    void Size_WhenRemoveElement_ShouldDecreaseSize() throws IndexOutOfBoundsException {
        int expectedSize = 5;
        Stack<Integer> stack = Stack.of(Builders.arrayOfNumbers(expectedSize));

        stack.pop();

        assertEquals(expectedSize - 1, stack.size());
    }

    @Test
    void IsEmpty_WhenEmpty_ShouldReturnTrue() {
        Stack<String> stack = new Stack<>();

        assertTrue(stack.isEmpty());
    }

    @Test
    void IsEmpty_WhenNotEmpty_ShouldReturnFalse() {
        Stack<String> stack = Stack.of("Not Empty");

        assertFalse(stack.isEmpty());
    }
}
