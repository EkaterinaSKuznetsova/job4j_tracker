package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions =  new ArrayList<UserAction>();
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions =  new ArrayList<UserAction>();
        actions.add(new CreateAction(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions =  new ArrayList<UserAction>();
        actions.add(new ReplaceItem(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<UserAction>();
       actions.add(new DeleteItem(out));
       actions.add(new Exit());
       new StartUI(out).init(in, tracker, actions);
       assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenShowAllItemWhenNoItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new ShowAllItems(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() + "0. Show all items" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "==== Show all items ====" + System.lineSeparator()
                + "Хранилище еще не содержит заявок" + System.lineSeparator()
                + "Menu." + System.lineSeparator() + "0. Show all items" + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAllItemWhenOneItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("First item"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new ShowAllItems(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() + "0. Show all items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "==== Show all items ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator() + "0. Show all items" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindItemByIdYes() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("First item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new FindItemByID(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "==== Find item by id ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator() + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindItemByIdNo() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        int id = 1;
        Input in = new StubInput(
                new String[] {"0", String.valueOf(id), "1"}
        );
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new FindItemByID(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "==== Find item by id ====" + System.lineSeparator()
                        + "Заявка с введенным id:" + id + " не найдена" + System.lineSeparator()
                        + "Menu." + System.lineSeparator() + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindItemByNameYes() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("First item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getName()), "1"}
        );
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new FindItemByName(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "==== Find items by name ====" + System.lineSeparator()
                        + item + System.lineSeparator()
                        + "Menu." + System.lineSeparator() + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }
    @Test
    public void whenFindItemByNameNo() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        String name = "First name";
        Input in = new StubInput(
                new String[] {"0", name, "1"}
        );
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new FindItemByName(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
                        + "==== Find items by name ====" + System.lineSeparator()
                        + "Заявки с именем: " + name + " не найдены." + System.lineSeparator()
                        + "Menu." + System.lineSeparator() + "0. Find items by name" + System.lineSeparator()
                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"7","0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit" + ln
                )
        );
    }
}
