package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {

    public String[] remove(String[] array) {
        int smal = array.length;
        for (int i = 0; i < smal; i++) {
            for (int j = i + 1; j < smal; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[smal - 1];
                    smal--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, smal);
    }
}
