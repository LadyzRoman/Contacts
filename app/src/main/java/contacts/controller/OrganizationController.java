package contacts.controller;

import contacts.View;
import contacts.model.ArrayListPhoneBook;
import contacts.model.Organization;
import contacts.model.Person;
import contacts.model.PhoneBook;
import contacts.model.provider.OrganizationProvider;
import menu.MenuElement;
import menu.impl.StringKeyMenu;

public class OrganizationController extends RecordController {

    private final OrganizationProvider provider;

    public OrganizationController(View view, PhoneBook model, OrganizationProvider provider) {
        super(view, model, provider);
        this.provider = provider;
    }

    @Override
    protected void init() {
        var builder = StringKeyMenu.getBuilder();
        builder.reset()
                .setTitle("Select a field")
                .addOption(new MenuElement<>("name",
                        s -> changeOrgName()))
                .addOption(new MenuElement<>("address",
                        s -> changeAddress()))
                .addOption(new MenuElement<>("number",
                        s -> changePhoneNumber()));
        editMenu = builder.build();
    }

    private void changePhoneNumber() {
        //TODO
        model.edit(index, new Organization(provider));
    }

    private void changeAddress() {
        //TODO
        model.edit(index, new Organization(provider));
    }

    private void changeOrgName() {
        //TODO
        model.edit(index, new Organization(provider));
    }
}
