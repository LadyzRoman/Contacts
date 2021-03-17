package contacts.controller;

import contacts.View;
import contacts.model.Organization;
import contacts.model.Person;
import contacts.model.PhoneBook;
import contacts.model.Record;
import contacts.model.provider.OrganizationProvider;
import contacts.model.provider.PersonProvider;
import menu.MenuElement;
import menu.impl.StringKeyMenu;

public class PhoneBookController extends Controller {
    private final PersonProvider personProvider;
    private final OrganizationProvider organizationProvider;
    private StringKeyMenu mainMenu;
    private StringKeyMenu personTypeMenu;

    private ListController listController;
    private SearchController searchController;

    public PhoneBookController(View view, PhoneBook model,
                               ListController listController, SearchController searchController,
                               PersonProvider personProvider, OrganizationProvider organizationProvider) {
        super(view, model);
        this.listController = listController;
        this.searchController = searchController;
        this.personProvider = personProvider;
        this.organizationProvider = organizationProvider;
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
        builder.reset()
                .setTitle("Enter the type")
                .addOption(new MenuElement<>("person",
                        s -> addRecord(new Person(personProvider))))
                .addOption(new MenuElement<>("organization",
                        s -> addRecord(new Organization(organizationProvider))));
        personTypeMenu = builder.build();
    }

    public void add() {
        view.showMenu(personTypeMenu);
        executeAction(personTypeMenu);
        view.showMessage("The record added!");
    }

    public void addRecord(Record record) {
        model.add(record);
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
