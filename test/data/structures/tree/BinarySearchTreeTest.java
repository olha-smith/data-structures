package data.structures.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void addTest_whenEmpty() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Integer testData = 10;

        assertTrue(tree.add(testData));
        assertTrue(tree.contains(testData));
    }

    @Test
    void addTest_whenNotEmpty() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Integer testData_root = 10;
        Integer testData_smaller = 8;
        Integer testData_bigger = 15;

        tree.add(testData_root);
        tree.add(testData_smaller);
        tree.add(testData_bigger);

        assertTrue(tree.contains(testData_smaller));
        assertTrue(tree.contains(testData_bigger));
    }

    @Test
    void addTest_whenBigTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Integer[] data = {10, 8, 15, 9, 0, 10, 20};

        for (int i = 0; i < data.length - 1; i++) {
            tree.add(data[i]);
        }

        for (int i = 0; i < data.length - 1; i++) {
            assertTrue(tree.contains(data[i]));
        }
    }

    @Test
    void removeTest_whenBigTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Integer[] data = {10, 8, 15, 9, 0, 20};

        for (int i = 0; i < data.length; i++) {
            tree.add(data[i]);
        }

        for (int i = data.length - 1; i >= 0; i--) {
            tree.remove(data[i]);
        }

        assertTrue(tree.isEmpty());
    }
}