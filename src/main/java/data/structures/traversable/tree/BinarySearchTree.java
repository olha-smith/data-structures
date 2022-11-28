package data.structures.traversable.tree;

import java.util.Objects;

public class BinarySearchTree<T extends Comparable<T>> {

     BinaryTreeNode rootNode;

     class BinaryTreeNode implements Tree {
        T data;
        BinaryTreeNode parent;
        BinaryTreeNode rightChild;
        BinaryTreeNode leftChild;

        BinaryTreeNode(T data, BinaryTreeNode parent, BinaryTreeNode rightChild, BinaryTreeNode leftChild) {
            this.data = data;
            this.parent = parent;
            this.rightChild = rightChild;
            this.leftChild = leftChild;
        }
    }

    public static BinarySearchTree<Integer> of(int... values) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        for (int value: values) {
            tree.add(value);
        }

        return tree;
    }

    public boolean add(T data) {
        if (this.isEmpty()) {
            rootNode = new BinaryTreeNode(data, null,null, null);
            return true;
        }

        BinaryTreeNode currentNode = rootNode;
        while (!currentNode.data.equals(data)) {
            int compareValue = data.compareTo(currentNode.data);

            if (compareValue < 0) {
                if (currentNode.leftChild != null) {
                    currentNode = currentNode.leftChild;
                } else {
                    currentNode.leftChild = new BinaryTreeNode(data, currentNode,null, null);
                    return true;
                }
            } else {
                if (currentNode.rightChild != null) {
                    currentNode = currentNode.rightChild;
                } else {
                    currentNode.rightChild = new BinaryTreeNode(data, currentNode,null, null);
                    return true;
                }
            }
        }

        return false;
    }

    public boolean remove(T data) {
         BinaryTreeNode nodeToRemove = search(data);
         if (nodeToRemove == null) {
             return false;
         }

         return remove(nodeToRemove);
    }
    
    private boolean removeLeaf(BinaryTreeNode leaf) {
        if (leaf == rootNode) {
            rootNode = null;
        } else {
            if (leaf.data.compareTo(leaf.parent.data) > 0) {
                leaf.parent.rightChild = null;
            } else {
                leaf.parent.leftChild = null;
            }
        }

        return true;
    }

    private boolean removeNodeWithOnlyChild(BinaryTreeNode node) {
        BinaryTreeNode child = Objects.requireNonNullElseGet(node.rightChild, () -> node.leftChild);

        if (node == rootNode) {
            rootNode = child;
            child.parent = null;
        } else {
            if (node.data.compareTo(node.parent.data) > 0) {
                node.parent.rightChild = child;
            } else {
                node.parent.leftChild = child;
            }
            child.parent = node.parent;
        }

        return true;
    }

    private boolean removeNodeWithBothChildren(BinaryTreeNode node) {
        BinaryTreeNode targetChild = node.rightChild;

        while (targetChild.leftChild != null) {
            targetChild = targetChild.leftChild;
        }

        T data = targetChild.data;
        remove(targetChild);
        node.data = data;

        return true;
    }

    private boolean remove(BinaryTreeNode node) {
        if (node.rightChild == null && node.leftChild == null) {
            return removeLeaf(node);
        } else if (node.rightChild != null && node.leftChild != null) {
            return removeNodeWithBothChildren(node);
        } else {
            return removeNodeWithOnlyChild(node);
        }
    }

    public boolean contains(T data) {
        return (search(data) != null);
    }

    BinaryTreeNode search(T data) {
        if (isEmpty()) {
            return null;
        }

        BinaryTreeNode currentNode = rootNode;

        while (!currentNode.data.equals(data)) {
            int compareValue = data.compareTo(currentNode.data);
            BinaryTreeNode targetChild;

            if (compareValue < 0) {
                targetChild = currentNode.leftChild;
            } else {
                targetChild = currentNode.rightChild;
            }

            if (targetChild == null) {
                return null;
            }

            currentNode = targetChild;
        }

        return currentNode;
    }

    public boolean isEmpty() {
        return rootNode == null;
    }
}
