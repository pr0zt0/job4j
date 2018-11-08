package ru.job4j.last;

import java.util.Arrays;

/**
 * Данный класс нужен для разбиение массива
 * на две равные части
 * @author MKG
 * @version 1.0
 */
public class Task {

    public int[] shateTwoHeap(int[] array) {
        double summ = 0;
        int heap1 = 0, heap2 = 0;

        //Цикл для подсчета суммы всех чисел в массиве
        for (int i = 0; i < array.length; i++) {
            summ += array[i];
        }
        //выставляем приблизительную границу
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
}