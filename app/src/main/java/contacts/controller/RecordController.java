package contacts.controller;

import contacts.View;
import contacts.model.Organization;
import contacts.model.Person;
import contacts.model.PhoneBook;
import contacts.model.provider.RecordProvider;
import menu.Menu;
import menu.MenuElement;
import menu.impl.StringKeyMenu;

public class RecordController extends Controller {
    protected int index;
    protected RecordProvider provider;
    protected Menu<String> editMenu;

    public RecordController(View view, PhoneBook model, RecordProvider provider) {
        super(view, model);
        this.provider = provider;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    protected void init() {
        var builder = StringKeyMenu.getBuilder();
        builder.reset()
                .setTitle("[record] Enter action")
                .addOption(new MenuElement<>("edit", s -> edit()))
                .addOption(new MenuElement<>("delete", s -> delete()))
                .addOption(new MenuElement<>("menu", s -> {}));
        menu = builder.build();

        builder.reset()
                .setTitle("Edit menu");
        editMenu = builder.build();
    }

    public void run() {
        var current = model.getRecord(index);
        MenuElement<String> action;
        do {
            view.showRecordInfo(current);
            view.showMenu(menu);
            action = executeAction(menu);
        }
        while (!action.toString().equals("menu"));
    }

    public void delete() {
        model.remove(index);
    }

    public void edit() {
        view.showMenu(editMenu);
        executeAction(editMenu);
        System.out.println("Saved");
    }
}
