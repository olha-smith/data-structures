package data.structures.collection.list;

import data.structures.exceptions.IndexOutOfBoundsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static data.structures.utils.Builders.*;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    @Test
    public void Add_WhenEmpty_ShouldAddElement() throws IndexOutOfBoundsException {
        LinkedList<String> list = new LinkedList<>();
        String newElement = "Hello";

        list.add(newElement);

        assertEquals(newElement, list.get(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10})
    public void Add_WhenNotEmpty_ShouldAddElementToTail(int listSize) throws IndexOutOfBoundsException {
        LinkedList<String> list = new LinkedList<>();
        String[] values = {"Hello", "," ," Sweetie", "!", " Happy", " Learning", " Programming", " To", " You", " :3"};

        for (int i = 0; i < listSize; i++) {
            list.add(values[i]);
        }

        assertEquals(values[listSize - 1], list.get(listSize - 1));
    }

    @Test
    public void Add_WhenAddByIndex_ShouldAddElementInRightPlace() throws IndexOutOfBoundsException {
        String[] values = {"Hello", "World", "!", ""};
        LinkedList<String> list = new LinkedList<>();

        for (int i = 0; i < values.length; i++) {
            list.add(i, values[i]);
            assertEquals(values[i], list.get(i));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 1})
    public void Add_WhenIndexOutOfBound_ShouldThrowException(int index) {
        LinkedList<Integer> list = new LinkedList<>();
        Integer newElement = 26;

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(index, newElement));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10})
    public void Size_WhenAddElement_ShouldIncreaseSize(int expectedSize) {
        LinkedList<Integer> list = buildLinkedList(expectedSize);

        assertEquals(list.size(), expectedSize);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10})
    public void Size_WhenRemoveElement_ShouldDecreaseSize(int expectedSize) throws IndexOutOfBoundsException {
        LinkedList<Integer> list = buildLinkedList(expectedSize);

        list.remove(0);

        assertEquals(list.size(), expectedSize -1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void Remove_WhenNotEmpty_ShouldReturnRemovedValue(int index) throws IndexOutOfBoundsException {
        LinkedList<String> list = LinkedList.of("Hello", "World", "!", "");

        String valueToRemove = list.get(index);

        assertEquals(list.remove(index), valueToRemove);
    }

    @Test
    public void Remove_WhenEmpty_ShouldThrowException() {
        LinkedList<String> list = new LinkedList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void Set_WhenNotEmpty_ShouldReplaceOldElementWithNew(int index) throws IndexOutOfBoundsException {
        LinkedList<String> list = LinkedList.of("Hello", "World", "!", " ");
        String elementToAdd = "New Element";

        String elementToReplace = list.get(index);
        String result = list.set(index, elementToAdd);

        assertEquals(elementToReplace, result);
        assertEquals(list.get(index), elementToAdd);
    }

    @Test
    public void Set_WhenEmpty_ShouldThrowException() {
        LinkedList<String> list = new LinkedList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, "New"));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void Contains_WhenElementIsInList_ShouldReturnTrue(int index) throws IndexOutOfBoundsException {
        LinkedList<String> list = LinkedList.of("Hello", "World", "!", " ");

        String expected = list.get(index);

        assertTrue(list.contains(expected));
    }

    @Test
    public void Contains_WhenElementIsNotInList_ShouldReturnFalse() {
        String expectedString = "Hello";
        LinkedList<String> list = new LinkedList<>();

        assertFalse(list.contains(expectedString));
    }

    @Test
    void IndexOf_WhenContainsValue_ShouldReturnIndex() {
        ArrayList<Integer> list = buildArrayList(arrayOfNumbers(10));
        Integer valueToFind = 5;

        assertEquals(5, list.indexOf(valueToFind));
    }

    @Test
    void IndexOf_WhenNotContainsValue_ShouldReturnMinusOne() {
        ArrayList<Integer> list = buildArrayList(arrayOfNumbers(10));
        Integer valueToFind = 15;

        assertEquals(-1, list.indexOf(valueToFind));
    }
}
