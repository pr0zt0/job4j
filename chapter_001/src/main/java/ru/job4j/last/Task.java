package ru.job4j.last;

import ru.job4j.array.BubbleSort;

import java.util.Arrays;

/**
 * Данный класс нужен для разбиение массива
 * на две равные части
 * @author MKG
 * @version 1.0
 */
public class Task {
    /**
     * Method shateTwoHeap
     * @param array - исходный массив
     * @return array - в котором хранится два числа
     * array[0] - первая половина
     * array[1] - вторая половина
     */
    public int[] shateTwoHeap(int[] array) {
        double summ = 0;
        int heap1 = 0, heap2 = 0;
        for (int i = 0; i < array.length; i++) {
            summ += array[i];
        }
        summ /= 2;

        for (int i = 0; i < array.length; i++) {
            if (heap1 + array[i] <= summ || heap1 == 0) {
                heap1 += array[i];
            } else {
                heap2 += array[i];
            }
        }
        array[0] = heap1;
        array[1] = heap2;
        return Arrays.copyOf(array, 2);
    }
    /**
     * Method shateFromMinToMax
     * @param array - исходный массив
     * @return array - в котором хранится два числа
     * array[0] - первая половина
     * array[1] - вторая половина
     */
    public int[] shateFromMinToMax(int[] array) {
        double summ = 0;
        int heap1 = 0, heap2 = 0, temp;

        for (int i = 0; i < array.length; i++) {
            summ += array[i];
        }
        summ /= 2;
        BubbleSort bsort = new BubbleSort();
        array = bsort.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (heap1 < heap2 || heap1 == heap2) {
                heap1 += array[i];
            } else {
                heap2 += array[i];
            }
        }
        array[0] = heap1;
        array[1] = heap2;
        return Arrays.copyOf(array, 2);
    }
    /**
     * Method chooseBetter
     * Выбирает какой метод лучше разбил массив
     * @param arrayHeap - что получилось на выходе из 1 метода
     * @param arrayMinToMax - что получилось на выходе из 2 метода
     * @return arrayHeap - если 1 метод лучше
     * @return arrayMinToMax - если 2 метод лучше
     * array[0] - первая половина
     * array[1] - вторая половина
     */
    public int[] chooseBetter(int[] arrayHeap, int[] arrayMinToMax) {
        if (Math.abs(arrayHeap[0] - arrayHeap[1]) < Math.abs(arrayMinToMax[0] - arrayMinToMax[1])) {
            return arrayHeap;
        } else {
            return arrayMinToMax;
        }
    }
}