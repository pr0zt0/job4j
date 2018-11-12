package ru.job4j.profession;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfessionTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Profession cop = new Profession();
        String result = cop.getName("Bob");
        String expected = "Bob";
        assertThat(result, is(expected));
    }
}
