package ru.job4j.array;

/**
 * Класс для проверки диагонали
 */
public class Check {
    /**
     * Проверяет. что слово начинается с префикса.
     * @param data массив, который необходимо проверить.
     * @return возвращает true если диагональ состоит из одинаковых элементов
     * иначе false.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
          for (int i = 0; i < data.length; i++) {
              if (data[0] != data[i]) {
                  result = false;
                  break;
              }
          }
        return result;
    }
}
