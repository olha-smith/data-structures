package data.structures.queue;

import data.structures.list.LinkedList;

abstract class AbstractListBasedCollection<T> {

    protected LinkedList<T> list = new LinkedList<>();

    protected int size() {
        return list.size();
    }

    protected boolean isEmpty() {
        return list.isEmpty();
    }

}
