package data.structures.collection.set;

import data.structures.traversable.tree.BinarySearchTree;

public class TreeSet<T extends Comparable<T>> implements Set<T> {

    private int size = 0;

    BinarySearchTree<T> tree = new BinarySearchTree<>();

    @SafeVarargs
    public static <T extends Comparable<T>> TreeSet<T> of(T... values) {
        TreeSet<T> treeSet = new TreeSet<>();

        for (T value : values) {
            treeSet.add(value);
        }

        return treeSet;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.tree.isEmpty();
    }

    @Override
    public boolean contains(T data) {
        return tree.contains(data);
    }

    @Override
    public boolean add(T e) {
        if (this.tree.add(e)) {
            this.size++;
            return true;
        }

        return false;
    }

    @Override
    public boolean remove(T e) {
        if (this.tree.remove(e)) {
            this.size--;
            return true;
        }
        return false;
    }
}
