package data.structures.tree;

public class BinaryTreeNode<T extends Comparable<T>> {
    T data;
    BinaryTreeNode<T> parent;
    BinaryTreeNode<T> rightChild;
    BinaryTreeNode<T> leftChild;

    BinaryTreeNode(T data, BinaryTreeNode<T> parent, BinaryTreeNode<T> rightChild, BinaryTreeNode<T> leftChild) {
        this.data = data;
        this.parent = parent;
        this.rightChild = rightChild;
        this.leftChild = leftChild;
    }
}
