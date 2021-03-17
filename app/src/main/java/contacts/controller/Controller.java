package contacts.controller;

import contacts.View;
import contacts.model.ArrayListPhoneBook;
import contacts.model.PhoneBook;
import menu.Menu;
import menu.MenuElement;
import menu.MenuException;

public abstract class Controller {
    protected View view;
    protected Menu<String> menu;
    protected PhoneBook model;

    public Controller(View view, PhoneBook model) {
        this.view = view;
        this.model = model;
        init();
    }

    protected abstract void init();

    public void run() {
        view.showMenu(menu);
        executeAction(menu);
    }

    protected MenuElement<String> executeAction(Menu<String> menu) {
        while (true) {
            try {
                String option = view.getString();
                MenuElement<String> action = menu.getAction(option);
                action.execute(option);
                return action;
            } catch (MenuException e) {
                view.showMessage("Wrong option");
            }
        }
    }


}
