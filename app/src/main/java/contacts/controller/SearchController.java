package contacts.controller;

import contacts.View;
import contacts.model.PhoneBook;
import menu.Menu;
import menu.MenuElement;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import contacts.model.Record;
import menu.impl.RegexKeyMenu;

public class SearchController extends ListController {

    private List<Record> searchResult;

    public SearchController(View view, PhoneBook model, PersonController personController, OrganizationController organizationController) {
        super(view, model, personController, organizationController);
    }

    @Override
    protected void init() {
        var builder = RegexKeyMenu.getBuilder();
        builder.reset()
                .setTitle("[search] Enter action")
                .addOption("[0-9]+", new MenuElement<>("[number]", s -> selectRecord(Integer.parseInt(s) - 1)))
                .addOption(new MenuElement<>("back", s -> {
                }))
                .addOption(new MenuElement<>("again", s -> {
                }));
        menu = builder.build();
    }

    @Override
    public void run() {
        MenuElement<String> action;
        do {
            view.showMessage("Enter search query: ");
            Scanner sc = new Scanner(System.in);
            var query = sc.nextLine();
            searchResult = model.records()
                    .filter(r -> r.matches(query))
                    .collect(Collectors.toList());
            view.showRecords(searchResult);
            view.showMenu(menu);
            action = executeAction(menu);
        }
        while (action.toString().equals("again"));
    }

    @Override
    public void selectRecord(int index) {
        var foundedRecord = searchResult.get(index);
        var listIndex = model.getRecords().indexOf(foundedRecord);
        super.selectRecord(listIndex);
    }
}
