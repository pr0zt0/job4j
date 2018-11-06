package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        String[] word = new String[] {"Привет", "Мир", "Привет", "Супер", "Мир"};
        ArrayDuplicate some = new ArrayDuplicate();
        String[] res = some.remove(word);
        String[] exp = new String[] {"Привет", "Мир", "Супер"};
        assertThat(res, is(exp));
    }
}
