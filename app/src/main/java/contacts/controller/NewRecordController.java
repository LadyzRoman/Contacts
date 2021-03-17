package contacts.controller;

import contacts.View;
import contacts.model.*;
import contacts.model.Record;
import contacts.model.provider.OrganizationProvider;
import contacts.model.provider.PersonProvider;
import menu.MenuElement;
import menu.impl.StringKeyMenu;

public class NewRecordController extends Controller {
    private final PersonProvider personProvider;
    private final OrganizationProvider organizationProvider;

    public NewRecordController(View view, PhoneBook model, PersonProvider personProvider, OrganizationProvider organizationProvider) {
        super(view, model);
        this.personProvider = personProvider;
        this.organizationProvider = organizationProvider;
    }

    @Override
    protected void init() {
        var builder = StringKeyMenu.getBuilder();
        builder.reset()
                .setTitle("Enter the type")
                .addOption(new MenuElement<>("person",
                        s -> addRecord(new Person(personProvider))))
                .addOption(new MenuElement<>("organization",
                        s -> addRecord(new Organization(organizationProvider))));
        menu = builder.build();
    }

    @Override
    public void run() {
        super.run();
        view.showMessage("The record added!");
    }

    private void addRecord(Record record) {
        model.add(record);
    }
}
