package data.structures.traversable.tree;

public class BinarySearchTree<T extends Comparable<T>> {

    private BinaryTreeNode rootNode;

    private class BinaryTreeNode implements Tree {
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

    public boolean add(T data) {
        if (this.isEmpty()) {
            rootNode = new BinaryTreeNode(data, null,null, null);
            return true;
        }

        BinaryTreeNode currentNode = rootNode;
        while (data != currentNode.data) {
            Integer compareValue = data.compareTo(currentNode.data);

            if (compareValue < 0) {
                if (currentNode.leftChild != null) {
                    currentNode = currentNode.leftChild;
                    continue;
                } else {
                    currentNode.leftChild = new BinaryTreeNode(data, currentNode,null, null);
                    return true;
                }
            }

            if (compareValue > 0) {
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
        BinaryTreeNode removableNode = search(data);

        if (removableNode != null) {
            if (removableNode == rootNode) {
                rootNode = null;
                return true;
            }

            if (removableNode.parent.rightChild == removableNode) {
                removableNode.parent.rightChild = null;
            } else {
                removableNode.parent.leftChild = null;
            }

            removableNode.parent = null;
            return true;
        }

        return false;
    }

    public boolean contains(T data) {
        return (search(data) != null);
    }

    private BinaryTreeNode search(T data) {
        BinaryTreeNode currentNode = rootNode;

        while (currentNode.data != data) {
            Integer compareValue = data.compareTo(currentNode.data);
            BinaryTreeNode targetChild;

            if (compareValue < 0) {
                targetChild = currentNode.leftChild;
            } else {
                targetChild = currentNode.rightChild;
            }

            if (targetChild != null) {
                currentNode = targetChild;
            } else {
                return null;
            }
        }

        return currentNode;
    }

    public boolean isEmpty() {
        return rootNode == null;
    }
}