package ru.job4j.tracker;

import java.util.Scanner;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    private static final String FINDID = "4";
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private static final String SHOW = "1", EDIT = "2", DELETE = "3", FINDNAME = "5";


    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
             } else if (FINDID.equals(answer)) {
                this.findByIdItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            } else if (FINDNAME.equals(answer)) {
                this.findByNameItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItem();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            }
        }
    }


    private void deleteItem() {
        System.out.println("------------ Удаление заявки по ID --------------");
        String id = this.input.ask("Введите id заявки: ");
        this.tracker.delete(id);
        System.out.println("------------ Заявка удалена -----------");
    }
    private void editItem() {
        System.out.println("------------ Укажите ID для редактирование заявки --------------");
        String id = this.input.ask("Введите id заявки: ");
        String changeChoose = this.input.ask("Введите поле для редактирования (name или description): ");
        String fieldNew = this.input.ask("Введите новое значение: ");
        this.tracker.edit(id, changeChoose, fieldNew);
    }
    private void showAllItem() {
        System.out.println("------------ Текущие заявки --------------");
        int i = 0;
        while (i < this.tracker.findAll().length) {
            System.out.println("Заяка :" + "ID " + this.tracker.findAll()[i].getId() + " Имя " + this.tracker.findAll()[i].getName() + " Описание " + this.tracker.findAll()[i].getDescription());
            i++;
        }
    }
    private void findByNameItem() {
        System.out.println("------------ Поиск по key --------------");
        String key = this.input.ask("Введите key: ");
        for (int i = 0; i < this.tracker.findByName(key).length; i++) {
            System.out.println("Заяка :" + "ID " + this.tracker.findByName(key)[i].getId());
        }
    }
    /**
     * Метод поиска заявки по ID
     */
    private void findByIdItem() {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = this.input.ask("Введите id заявки: ");
        System.out.println("------------ Заявка с данным id : " +  this.tracker.findById(id) + "-----------");
    }
    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    private void showMenu() {
        System.out.println("Меню.\n" + "0. Add new Item\n" + "1. Show all items\n" + "2. Edit item\n" + "3. Delete item\n" + "4. Find item by Id\n" + "5. Find items by name\n" + "6. Exit Program\n");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
