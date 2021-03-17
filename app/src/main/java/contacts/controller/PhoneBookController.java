package contacts.controller;

import contacts.View;
import contacts.model.PhoneBook;
import menu.MenuElement;
import menu.impl.StringKeyMenu;

public class PhoneBookController extends Controller {
    private StringKeyMenu mainMenu;

    private final ListController listController;
    private final SearchController searchController;
    private final NewRecordController newRecordController;


    public PhoneBookController(View view, PhoneBook model,
                               ListController listController,
                               SearchController searchController,
                               NewRecordController newRecordController) {
        super(view, model);
        this.listController = listController;
        this.searchController = searchController;
        this.newRecordController = newRecordController;
    }

    public void init() {
        var builder = StringKeyMenu.getBuilder();
        builder.reset()
                .setTitle("[menu] Enter action")
                .addOption(new MenuElement<>("add", s -> add()))
                .addOption(new MenuElement<>("count", s -> count()))
                .addOption(new MenuElement<>("list", s -> list()))
                .addOption(new MenuElement<>("search", s -> search()))
                .addOption(new MenuElement<>("exit", s -> {}));
        mainMenu = builder.build();
    }

    public void add() {
        newRecordController.run();
    }

    public void count() {
        view.showMessage(String.format("The Phone Book has %d records.", model.getSize()));
    }

    public void list() {
        listController.run();
    }

    public void search() {
        searchController.run();
    }

    public void run() {
        MenuElement<String> action;
        do {
            view.showMenu(mainMenu);
            action = executeAction(mainMenu);
        } while (!action.toString().equals("exit"));
    }
}
