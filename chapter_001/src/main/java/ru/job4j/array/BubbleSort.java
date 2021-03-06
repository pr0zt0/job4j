package ru.job4j.array;

/**
 * Сортеровка пузырьком
 */
public class BubbleSort {
    /**
     * Проверяет. что слово начинается с префикса.
     * @param array массив.
     * @return возвращает отсортерованный массив
     */
    public int[] sort(int[] array) {
        int temp;
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    return array;
    }
}
