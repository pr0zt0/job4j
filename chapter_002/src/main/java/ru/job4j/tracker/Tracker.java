package ru.job4j.tracker;


import java.util.*;
/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();
    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public void edit(String id, String changeChoose, String fieldNew) {
        if (changeChoose.equals("name")) {
         findById(id).setName(fieldNew);
        } else if (changeChoose.equals("description")) {
            findById(id).setDescription(fieldNew);
        }
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Должен заменить ячейку в массиве this.items. Для этого необходимо найти ячейку в массиве по id
     * @param id Уникальный ключ
     * @param item Заяка на которую необходимо подменить
     */
    public void replace(String id, Item item) {
        for (int index = 0; index != this.position; index++) {
            if (items[index].getId().equals(id)) {
                items[index] = item;
                break;
            }
        }
    }

    /**
     *  должен удалить ячейку в массиве this.items. Для этого необходимо найти ячейку в массиве по id.
     *  Далее сместить все значения справа от удаляемого элемента - на одну ячейку влево с помощью System.arrayCopy();
     * @param id Уникальный ключ
     */
    public void delete(String id) {
        for (int index = 0; index != this.position; index++) {
            if (items[index].getId().equals(id)) {
                System.arraycopy(this.items, index + 1, this.items, index, items.length - (index + 1));
                break;
            }
        }
    }

    /**
     * @return  возвращает копию массива this.items без null элементов;
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }
    /*
    public Item[] findByName(String key) {
        int count = 0;
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            if (items[i].getName().equals(key)) {
                System.arraycopy(this.items, i, result, count++, 1);
            }
        }
        return result;
    }
    */

    public Item[] findByName(String key) {
        int count = 0;
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            if (items[i].getName().equals(key)) {
                result[count++] = items[i];
            }
        }
        return Arrays.copyOf(result, result.length);
    }
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}