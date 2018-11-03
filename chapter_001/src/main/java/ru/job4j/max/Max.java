package ru.job4j.max;

/**
 * @author MKG
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Сравнивает два числа
     * @param first Первое число
     * @param second Второе число
     * @return Наибольшее число
     */
    public int max(int first, int second) {
        return first - second > 0 ? first : second;
    }

    public int max(int first, int second, int third) {
        return this.max(third, max(first, second));
    }
}
