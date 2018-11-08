package ru.job4j.last;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TaskTest {
    @Test
    public void whenFirstArray10z5z1ThenFirstHeap10Second6() {
        Task last = new Task();
        int[] primalArray = new int[] {10, 5, 1};
        int[] res = last.shateTwoHeap(primalArray);
        int[] exp = new int[] {10, 6};
        assertThat(res, is(exp));
    }

    @Test
    public void whenArray12z24z41z2ThenFirstHeap38Second41() {
        Task last = new Task();
        int[] primalArray = new int[] {12, 24, 41, 2};
        int[] res = last.shateTwoHeap(primalArray);
        int[] exp = new int[] {38, 41};
        assertThat(res, is(exp));
    }
}

