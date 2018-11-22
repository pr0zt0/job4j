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
                if(!this.findByNameItem()) {
                    System.out.println("------------ Ошибка !-----------");
                }
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
        if(this.tracker.delete(id)) {
            System.out.println("------------ Заявка удалена -----------");
        } else {
            System.out.println("------------ Ошибка !-----------");
        }
    }
    private void editItem() {
        System.out.println("------------ Укажите ID для редактирование заявки --------------");
        String id = this.input.ask("Введите id заявки: ");
        String changeChoose = this.input.ask("Введите поле для редактирования (name или description): ");
        String fieldNew = this.input.ask("Введите новое значение: ");
        if(this.tracker.edit(id, changeChoose, fieldNew)) {
            System.out.println("------------ Заявка удалена -----------");
        } else {
            System.out.println("------------ Ошибка !-----------");
        }
    }
    private void showAllItem() {
        if (this.tracker.findAll().length == 0) {
            System.out.println("------------ Списoк пуст --------------");
        } else {
            System.out.println("------------ Текущие заявки --------------");
            for (Item temp : this.tracker.findAll()) {
                System.out.println(temp);
            }
        }
    }
    private boolean findByNameItem() {
        boolean flag = false;
        System.out.println("------------ Поиск по key --------------");
        String key = this.input.ask("Введите key: ");
        for (Item itemName : this.tracker.findByName(key)) {
            System.out.println(itemName);
            flag = true;
        }
        return flag;
    }
    /**
     * Метод поиска заявки по ID
     */
    private void findByIdItem() {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = this.input.ask("Введите id заявки: ");
        if (this.tracker.findById(id) == null) {
            System.out.println("Такой заявки нету");
        } else {
            System.out.println("------------ Заявка с данным id : " +  this.tracker.findById(id) + "-----------");
        }
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
