package data.structures.utils;

import data.structures.collection.list.LinkedList;

public class Builders {

    public static Integer[] arrayOfNumbers(int size) {
        Integer[] array = new Integer[size];

        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        return array;
    }

    @SuppressWarnings("unchecked")
    public static <T> LinkedList<T> buildLinkedList(int n) {
        LinkedList<T> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add((T) new Object());
        }

        return list;
    }
}
