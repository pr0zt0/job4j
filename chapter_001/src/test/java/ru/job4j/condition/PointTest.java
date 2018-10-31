package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;


public class PointTest {

    @Test
    public void whenFirstPoint0x1yAndSecondPoint2x5yThen4and4() {
        Point one = new Point(0, 1);
        Point two = new Point(2, 5);
        double result = one.distanceTo(two);
        assertThat(result, closeTo(4.4, 0.1));
    }
}
