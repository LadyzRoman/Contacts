package contacts.controller;

import contacts.View;
import contacts.model.ArrayListPhoneBook;
import contacts.model.Person;
import contacts.model.PhoneBook;
import contacts.model.provider.PersonProvider;
import menu.MenuElement;
import menu.impl.StringKeyMenu;

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
        //TODO
        model.edit(index, new Person(provider));
    }

    public void changeSurname() {
        //TODO
        model.edit(index, new Person(provider));
    }

    public void changeGender() {
        //TODO
        model.edit(index, new Person(provider));
    }

    public void changePhoneNumber() {
        //TODO
        model.edit(index, new Person(provider));
    }

    public void changeBirthDate() {
        //TODO
        model.edit(index, new Person(provider));
    }
}
