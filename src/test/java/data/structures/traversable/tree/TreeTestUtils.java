package data.structures.traversable.tree;

class TreeTestUtils {
    static <T extends Comparable<T>> T getRootNode(BinarySearchTree<T> tree) {
        return tree.rootNode.data;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    static <T extends Comparable<T>> T getRightChild(BinarySearchTree<T> tree, T parent) {
        BinarySearchTree.BinaryTreeNode parentNode = tree.search(parent);

        if (parentNode != null && parentNode.rightChild != null) {
            return (T) parentNode.rightChild.data;
        } else {
            return null;
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    static <T extends Comparable<T>> T getLeftChild(BinarySearchTree<T> tree, T data) {
        BinarySearchTree.BinaryTreeNode parentNode = tree.search(data);

        if (parentNode != null && parentNode.leftChild != null) {
            return (T) parentNode.leftChild.data;
        } else {
            return null;
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    static <T extends Comparable<T>> T getParent(BinarySearchTree<T> tree, T data) {
        BinarySearchTree.BinaryTreeNode parentNode = tree.search(data).parent;

        if (parentNode != null) {
            return (T) parentNode.data;
        } else {
            return null;
        }
    }
}
