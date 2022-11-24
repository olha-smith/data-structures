package data.structures.collection.list;

import data.structures.collection.Collection;
import data.structures.exceptions.IndexOutOfBoundsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static data.structures.collection.list.ArrayList.*;
import static data.structures.utils.Builders.arrayOfNumbers;
import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @Test
    void Add_WhenEmpty_ElementShouldBeAdded() throws IndexOutOfBoundsException {
        ArrayList<String> list = new ArrayList<>();
        String expected = "Hello";

        list.add(expected);

        assertEquals(list.get(0), expected);
    }

    @Test
    void Add_WhenNotEmpty_ElementShouldBeAdded() throws IndexOutOfBoundsException {
        ArrayList<String> list = ArrayList.of("Hello");
        String expected = "World";

        list.add(expected);

        assertEquals(list.get(1), expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, INITIAL_CAPACITY, 7, 10, 12, 15, 17, 19, 99, 1400})
    void Add_WhenInternalArrayIsFull_ShouldIncreaseCapacity(int size) {
        Integer[] values = arrayOfNumbers(size);
        ArrayList<Integer> list = ArrayList.of(values);
        int currentCapacity = list.getCapacity();
        int nextIncreaseSize = (int) Math.ceil(LOAD_FACTOR * currentCapacity) + 1;
        int numberOfElemToAdd = nextIncreaseSize - size + 1;

        append(list, 0, numberOfElemToAdd);

        assertEquals((int)(currentCapacity * INCREASE_FACTOR), list.getCapacity());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 10, 2700})
    void Add_WithIndex_ElementShouldBeAddedByRightIndex(int index) throws IndexOutOfBoundsException {
        Integer[] values = arrayOfNumbers(index + 1);
        ArrayList<Integer> list = ArrayList.of(values);
        Integer expected = 12;

        list.add(index, expected);

        assertEquals(expected, list.get(index));
        assertTrue(containsAll(list, values));
    }

    @Test
    void Contains_WhenValueInList_ShouldReturnTrue() {
        Integer expected = 5;
        ArrayList<Integer> list = ArrayList.of(1, 2, 3, expected, 10);

        assertTrue(list.contains(expected));
    }

    @Test
    void Contains_WhenValueNotInList_ShouldReturnFalse() {
        Integer expected = 5;
        ArrayList<Integer> list = ArrayList.of(1, 2, 3, 10);

        assertFalse(list.contains(expected));
    }

    @Test
    void Contains_WhenEmptyListIsContainsNull_ShouldReturnFalse() {
        ArrayList<Integer> list = ArrayList.of();

        assertFalse(list.contains(null));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 10, 2700})
    void Size_ShouldBeEqualsNumberOfElements(int size) {
        ArrayList<Integer> list = ArrayList.of(arrayOfNumbers(size));

        assertEquals(size, list.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 10, 2700})
    void Remove_WhenNotEmpty_ShouldRemoveElementByIndex(int index) throws IndexOutOfBoundsException {
        Integer[] values = arrayOfNumbers(index + 1);
        ArrayList<Integer> list = ArrayList.of(values);
        Integer valueToRemove = list.get(index);

        assertEquals(valueToRemove, list.remove(index));
        assertEquals(list.size(), index);
        assertTrue(containsAll(list, subtract(values, valueToRemove)));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 10, 2700})
    void Remove_WhenIndexOutOfBounds_ShouldThrowException(int index) {
        ArrayList<Integer> list = ArrayList.of(arrayOfNumbers(index));

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(index));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 10, 2700})
    void Add_WhenIndexOutOfBounds_ShouldThrowException(int index) {
        ArrayList<Integer> list = ArrayList.of(arrayOfNumbers(index));

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(index + 1, index));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 10, 2700})
    void Get_WhenIndexOutOfBounds_ShouldThrowException(int index) {
        ArrayList<Integer> list = ArrayList.of(arrayOfNumbers(index));

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(index));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 10, 2700})
    void Set_WhenNotEmpty_ShouldReplaceElementAndReturnReplacedElement(int index) throws IndexOutOfBoundsException {
        ArrayList<Integer> list = ArrayList.of(arrayOfNumbers(index + 1));
        Integer newElement = 15;

        assertEquals(list.get(index), list.set(index, newElement));
        assertEquals(newElement, list.get(index));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 10, 2700})
    void Set_WhenEmpty_ShouldThrowException(int index) {
        ArrayList<Integer> list = ArrayList.of(arrayOfNumbers(index));
        Integer newElement = 15;

        assertThrows(IndexOutOfBoundsException.class, () -> list.set(index, newElement));
    }

    @Test
    void IndexOf_WhenContainsValue_ShouldReturnIndex() {
        ArrayList<Integer> list = ArrayList.of(arrayOfNumbers(10));
        Integer valueToFind = 5;

        assertEquals(5, list.indexOf(valueToFind));
    }

    @Test
    void IndexOf_WhenNotContainsValue_ShouldReturnMinusOne() {
        ArrayList<Integer> list = ArrayList.of(arrayOfNumbers(10));
        Integer valueToFind = 15;

        assertEquals(-1, list.indexOf(valueToFind));
    }

    private <T> void append(List<T> list, T value, int n) {
        for (int i = 0; i < n; i++) {
            list.add(value);
        }
    }

    private <T> boolean containsAll(Collection<T> list, T[] elements) {
        for (T element : elements) {
            if (!list.contains(element)) {
                return false;
            }
        }
        return true;
    }

    private Integer[] subtract(Integer[] array, Integer... values) {
        return Arrays.stream(array)
                .filter(v -> Arrays.stream(values).noneMatch(v::equals))
                .toArray(Integer[]::new);
    }
}