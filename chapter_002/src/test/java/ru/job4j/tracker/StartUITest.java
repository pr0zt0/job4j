package ru.job4j.tracker;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import java.util.StringJoiner;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUsershowAllItem() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(this.out.toString(), is(
                new StringBuilder()
                        .append("Меню.\n")
                        .append("0. Add new Item\n")
                        .append("1. Show all items\n")
                        .append("2. Edit item\n")
                        .append("3. Delete item\n")
                        .append("4. Find item by Id\n")
                        .append("5. Find items by name\n")
                        .append("6. Exit Program\n\r\n")
                        .append("------------ Текущие заявки --------------\r\n")
                        .append("Заявка : ID ")
                        .append(item.getId())
                        .append(" Имя test name Описание desc\r\n")
                        .append("Меню.\n0. Add new Item\n1. Show all items\n2. Edit item\n3. Delete item\n4. Find item by Id\n5. Find items by name\n6. Exit Program\n\r\n")
                        .toString()
            )
        );
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "name", "test replace", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenFindByIDThenTrackerShowSameItemID() {
        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("test name", "desc"));

        Input input = new StubInput(new String[]{"4", item.getId(), "6"});

        new StartUI(input, tracker).init();

        assertThat(tracker.findById(item.getId()).getDescription(), is("desc"));
    }

    @Test
    public void whenUserDeleteItemThenTrackerDeleteSameItem() {
        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("test name", "desc"));

        Item pusto = null;

        Input input = new StubInput(new String[]{"3", item.getId(), "6"});

        new StartUI(input, tracker).init();

        assertThat(tracker.findById(item.getId()), is(pusto));
    }


    @Test
    public void whenUserFindByNameThenTrackerShowAllFindByNameItem() {
        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("1", "desc"));

        Item second = tracker.add(new Item("1", "desc2"));

        Input input = new StubInput(new String[]{"5", "1", "6"});

        new StartUI(input, tracker).init();

        assertThat(tracker.findByName("1").length, is(2));
    }
}
