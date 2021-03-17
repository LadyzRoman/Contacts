package contacts.controller;

import contacts.View;
import contacts.model.Organization;
import contacts.model.Person;
import contacts.model.PhoneBook;
import contacts.model.Record;
import menu.MenuElement;
import menu.impl.RegexKeyMenu;

public class ListController extends Controller {
    private PersonController personController;
    private OrganizationController organizationController;

    public ListController(View view, PhoneBook model, PersonController personController, OrganizationController organizationController) {
        super(view, model);
        this.personController = personController;
        this.organizationController = organizationController;
    }

    @Override
    protected void init() {
        var builder = RegexKeyMenu.getBuilder();
        builder.reset()
                .setTitle("[list] Enter action")
                .addOption("[0-9]+", new MenuElement<>("[number]", s -> selectRecord(Integer.parseInt(s) - 1)))
                .addOption(new MenuElement<>("back", s -> {}));
        menu = builder.build();
    }

    public void run() {
        view.showRecords(model.getRecords());
        super.run();
    }

    public void selectRecord(int index) {
        Record record = model.getRecord(index);
        if (record instanceof Person) {
            personController.setIndex(index);
            personController.run();
        } else if (record instanceof Organization) {
            organizationController.setIndex(index);
            organizationController.run();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
