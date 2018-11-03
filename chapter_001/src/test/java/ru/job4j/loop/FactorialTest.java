package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void when5Then120() {
        Factorial sumEven = new Factorial();
        int res = sumEven.calc(5);
        assertThat(res, is(120));
    }
    @Test
    public void when0Then1() {
        Factorial sumEven = new Factorial();
        int res = sumEven.calc(0);
        assertThat(res, is(1));
    }
}
