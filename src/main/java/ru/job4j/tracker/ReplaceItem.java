package ru.job4j.tracker;

public class ReplaceItem implements  UserAction {
    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Edit Item ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка успешно изменена");
        } else {
            System.out.println("Ошибка замены заявки");
        }
        return true;
    }
}
