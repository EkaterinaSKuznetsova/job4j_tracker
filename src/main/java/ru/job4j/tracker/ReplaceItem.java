package ru.job4j.tracker;

public class ReplaceItem implements  UserAction {
    private final Output out;

    public ReplaceItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Edit Item ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Заявка успешно изменена");
        } else {
            out.println("Ошибка замены заявки");
        }
        return true;
    }
}
