package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CounterTest {

    @Test
    public void whenRange1To10Then30() {
        Counter sumEven = new Counter();
        int res = sumEven.add(1, 10);
        assertThat(res, is(30));
    }

}
