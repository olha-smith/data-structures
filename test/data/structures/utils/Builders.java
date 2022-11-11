package data.structures.utils;

import data.structures.collection.list.ArrayList;
import data.structures.collection.list.LinkedList;

public class Builders {

    public static <T> ArrayList<T> buildArrayList(T... values) {
        ArrayList<T> list = new ArrayList<>();

        for (T value : values) {
            list.add(value);
        }

        return list;
    }

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

    public static <T> LinkedList<T> buildLinkedList(T[] values) {
        LinkedList<T> list = new LinkedList<>();

        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }

        return list;
    }

}
