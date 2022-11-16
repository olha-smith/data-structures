package data.structures.collection.set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TreeSetTest {

    @Test
    void Add_WhenEmpty_ShouldAddElement() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        Integer expected = 2600;

        treeSet.add(expected);

        assertTrue(treeSet.contains(expected));
    }

    @Test
    void Add_WhenTryAddSameValue_ShouldAddOnlyUniqueValue() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        Integer expected = 2600;

        treeSet.add(expected);
        assertTrue(treeSet.contains(expected));
        assertEquals(1, treeSet.size());

        treeSet.add(expected);
        assertTrue(treeSet.contains(expected));
        assertEquals(1, treeSet.size());
    }

    @Test
    void IsEmpty_WhenEmpty_ShouldReturnTrue() {
        TreeSet<Integer> treeSet = new TreeSet<>();

        assertTrue(treeSet.isEmpty());
    }

    @Test
    void IsEmpty_WhenNotEmpty_ShouldReturnFalse() {
        TreeSet<Integer> treeSet = TreeSet.of(0, 1, 2600);

        assertFalse(treeSet.isEmpty());
    }

    @ParameterizedTest
    @ValueSource (ints = {0, 1, 2, 10, 2600})
    void Remove_WhenNotEmpty_ShouldRemoveRightElement(int value) {
        TreeSet<Integer> treeSet = TreeSet.of(0, 1, 2, 10, 2600);
        int initialSize = treeSet.size();

        treeSet.remove(value);

        assertFalse(treeSet.contains(value));
        assertEquals(initialSize - 1, treeSet.size());
    }
}
