package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *	Test
 *	@author MKG
 *	@version $Id$
 *	@since 0.1
 */
public class CalculatorTest {
    /**
     * Test addition
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test substract
     */
    @Test
    public void whenSubstractTwoMinOneThenOne() {
        Calculator calc = new Calculator();
        calc.substract(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test div
     */
    @Test
    public void whenDivNineAndThreeThenThree() {
        Calculator calc = new Calculator();
        calc.div(9D, 3D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }

    /**
     * Test multiple
     */
    public void whenMultipleTwoAndTwoThenFour() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }
}
