package ru.job4j.last;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TaskTest {
    /**
     * Test shateTwoHeap
     */
    @Test
    public void whenFirstArray10z5z1ThenFirstHeap10Second6() {
        Task last = new Task();
        int[] primalArray = new int[] {10, 5, 1};
        int[] res = last.shateTwoHeap(primalArray);
        int[] exp = new int[] {10, 6};
        assertThat(res, is(exp));
    }
    /**
     * Test shateTwoHeap
     */
    @Test
    public void whenArray12z24z41z2ThenFirstHeap38Second41() {
        Task last = new Task();
        int[] primalArray = new int[] {12, 24, 41, 2};
        int[] res = last.shateTwoHeap(primalArray);
        int[] exp = new int[] {38, 41};
        assertThat(res, is(exp));
    }
    /**
     * Test shateTwoHeap
     */
    @Test
    public void whenArrays1and2and3and4and5ThenFirstHeap6SecondHeap9() {
        Task last = new Task();
        int[] primalArray = new int[] {1, 2, 3, 4, 5};
        int[] res = last.shateFromMinToMax(primalArray);
        int[] exp = new int[] {9, 6};
        assertThat(res, is(exp));
    }
    /**
     * Test shateFromMinToMax
     */
    @Test
    public void whenArray12and24and41and2ThenFirstHeap53Second26() {
        Task last = new Task();
        int[] primalArray = new int[] {12, 24, 41, 2};
        int[] res = last.shateFromMinToMax(primalArray);
        int[] exp = new int[] {53, 26};
        assertThat(res, is(exp));
    }
    /**
     * Test chooseBetter
     */
    @Test
    public void whenFirstArrayAndSecondAraySameThenBetterFirst() {
        Task last = new Task();
        int[] primalArray = new int[] {12, 24, 41, 2};
        int[] first = last.shateTwoHeap(primalArray);
        int[] secondArray = new int[] {12, 24, 41, 2};
        int[] second = last.shateFromMinToMax(secondArray);
        int[] res = last.chooseBetter(first, second);
        assertThat(res, is(first));
    }
}


