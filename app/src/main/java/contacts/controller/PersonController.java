package contacts.controller;

import contacts.View;
import contacts.model.Organization;
import contacts.model.Person;
import contacts.model.PhoneBook;
import contacts.model.provider.PersonProvider;
import contacts.model.provider.RecordProvider;
import menu.Menu;
import menu.MenuElement;
import menu.impl.StringKeyMenu;

import java.time.LocalDateTime;

public class PersonController extends RecordController {
    private PersonProvider provider;

    public PersonController(View view, PhoneBook model, PersonProvider provider) {
        super(view, model, provider);
        this.provider = provider;
    }

    @Override
    protected void init() {
        var builder = StringKeyMenu.getBuilder();
        builder.reset()
                .setTitle("Select a field")
                .addOption(new MenuElement<>("name",
                        s -> changeName()))
                .addOption(new MenuElement<>("surname",
                        s -> changeSurname()))
                .addOption(new MenuElement<>("gender",
                        s -> changeGender()))
                .addOption(new MenuElement<>("birth",
                        s -> changeBirthDate()))
                .addOption(new MenuElement<>("number",
                        s -> changePhoneNumber()));
        editMenu = builder.build();
    }

    public void changeName() {

    }

    public void changeSurname() {

    }

    public void changeGender() {

    }

    public void changePhoneNumber() {

    }

    public void changeBirthDate() {

    }
}
