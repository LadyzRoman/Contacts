package contacts.controller;

import contacts.View;
import contacts.model.Organization;
import contacts.model.PhoneBook;
import contacts.model.provider.OrganizationProvider;
import menu.MenuElement;
import menu.impl.StringKeyMenu;

public class OrganizationController extends RecordController {
    public OrganizationController(View view, PhoneBook model, OrganizationProvider provider) {
        super(view, model, provider);
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

    }

    private void changeAddress() {

    }

    private void changeOrgName() {

    }
}
