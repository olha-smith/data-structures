package data.structures.traversable.tree;

import data.structures.collection.list.ArrayList;
import data.structures.exceptions.IndexOutOfBoundsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void Add_WhenEmpty_ShouldAddElement() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Integer testData = 10;

        assertTrue(tree.add(testData));
        assertTrue(tree.contains(testData));
    }

    @Test
    void Add_WhenNotEmpty_ShouldAddElementInRightPlace() {
        BinarySearchTree<Integer> tree = BinarySearchTree.of(3000);
        Integer[] values = {2600, 10, 8, 6, 5, 0};

        for (Integer value: values) {
            assertTrue(tree.add(value));

            assertTrue(Objects.requireNonNull(TreeTestUtils.getParent(tree, value)).compareTo(value) > 0);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 2, 8, 10, 5, 7, 6})
    void Remove_WhenNotEmpty_ShouldRemoveOnlyTargetElement(int removableValue) throws IndexOutOfBoundsException {
        Integer[] values = {4, 2, 8, 10, 5, 7, 6};
        BinarySearchTree<Integer> tree = BinarySearchTree.of(4, 2, 8, 10, 5, 7, 6);
        ArrayList<Integer> expectedValues = new ArrayList<>();

        for (Integer value : values) {
            expectedValues.add(value);
        }

        expectedValues.remove(expectedValues.indexOf(removableValue));

        assertTrue(tree.remove(removableValue));
        assertFalse(tree.contains(removableValue));

        for (int i = 0; i < expectedValues.size(); i++) {
            assertTrue(tree.contains(expectedValues.get(i)));
        }
    }

    @Test
    void Remove_WhenValueNotInTree_ShouldReturnFalse() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Integer outOfTreeValue = 3;

        assertFalse(tree.remove(outOfTreeValue));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 5, 9})
    void Remove_WhenRemoveLeftLeaf_ShouldRemoveLinksFromParent(int leafValue) {
        BinarySearchTree<Integer> tree = BinarySearchTree.of(4, 2, 8, 5, 10, 9);
        Integer parentNode = TreeTestUtils.getParent(tree, leafValue);

        tree.remove(leafValue);

        assertNull(TreeTestUtils.getLeftChild(tree, parentNode));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 7, 10})
    void Remove_WhenRemoveRightLeaf_ShouldRemoveLinksFromParent(int leafValue) {
        BinarySearchTree<Integer> tree = BinarySearchTree.of(4, 2, 8, 3, 10, 5, 7);
        Integer parentNode = TreeTestUtils.getParent(tree, leafValue);

        tree.remove(leafValue);

        assertNull(TreeTestUtils.getRightChild(tree, parentNode));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 8})
    void Remove_WhenRemoveNodeWithOneChild_ShouldGiveNewParentToChild (int nodeWithOneChild) {
        BinarySearchTree<Integer> tree = BinarySearchTree.of(4, 2, 8, 9, 3);
        Integer rightChild = TreeTestUtils.getRightChild(tree, nodeWithOneChild);
        Integer parent = TreeTestUtils.getParent(tree, nodeWithOneChild);

        tree.remove(nodeWithOneChild);

        assertEquals(parent, TreeTestUtils.getParent(tree, rightChild));
    }

    @Test
    void Remove_WhenRemoveRootNodeWithOneChild_ShouldTurnChildIntoRootNode() {
        BinarySearchTree<Integer> tree = BinarySearchTree.of(4, 2);

        tree.remove(4);

        assertEquals(2, TreeTestUtils.getRootNode(tree));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 7, 9})
    void Remove_WhenRemoveNodeWithBothChildren_ShouldNotLoseChildren(int value) {
        BinarySearchTree<Integer> tree = BinarySearchTree.of(4, 2, 1, 3, 9, 10, 7, 5, 6);
        Integer rightChild = TreeTestUtils.getRightChild(tree, value);
        Integer leftChild = TreeTestUtils.getLeftChild(tree, value);

        tree.remove(value);

        if (rightChild != null) {
            assertTrue(tree.contains(rightChild));
        }

        if (leftChild != null) {
            assertTrue(tree.contains(leftChild));
        }
    }

    @Test
    void Remove_WhenRemoveRootNode_ShouldReassignRootNode() {
        BinarySearchTree<Integer> tree = BinarySearchTree.of(4, 2, 8, 10, 5, 7, 6);

        while (!tree.isEmpty()) {
            Integer expected = TreeTestUtils.getRootNode(tree);

            tree.remove(expected);

            if (!tree.isEmpty()) {
                assertNotEquals(expected, TreeTestUtils.getRootNode(tree));
            }
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 10, 2600})
    void Contains_WhenValueInTree_ShouldReturnTrue(int value) {
        BinarySearchTree<Integer> tree = BinarySearchTree.of(1, 2, 10, 2600);

        assertTrue(tree.contains(value));
    }

    @Test
    void Contains_WhenValueNotInTree_ShouldReturnFalse() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        int value = 10;

        assertFalse(tree.contains(value));
    }
}
