package data.structures.utils;

import data.structures.collection.list.ArrayList;

public class Builders {

    public static <T> ArrayList<T> buildList(T... values) {
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


}
