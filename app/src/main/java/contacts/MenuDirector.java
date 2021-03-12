package contacts;


import contacts.model.Organization;
import contacts.model.Person;
import contacts.model.provider.KeyboardOrganizationProvider;
import contacts.model.provider.KeyboardPersonProvider;
import menu.Menu.Builder;
import menu.MenuElement;

public class MenuDirector {
    private Builder<String> builder;

    public MenuDirector(Builder<String> builder) {
        this.builder = builder;
    }

    public void buildMainMenu(PhoneBookController controller) {
        builder.reset()
                .setTitle("[menu] Enter action")
                .addOption(new MenuElement<>("add", s -> controller.add()))
                .addOption(new MenuElement<>("count", s -> controller.count()))
                .addOption(new MenuElement<>("list", s -> controller.list()))
                .addOption(new MenuElement<>("search", s -> controller.search()))
                .addOption(new MenuElement<>("exit", s -> controller.exit()));
    }

    public void buildRecordMenu(PhoneBookController controller) {
        builder.reset()
                .setTitle("[record] Enter action")
                .addOption(new MenuElement<>("edit", s -> controller.edit()))
                .addOption(new MenuElement<>("delete", s -> controller.delete()))
                .addOption(new MenuElement<>("menu", s -> controller.back()));
    }

    public void buildSearchMenu(PhoneBookController controller) {
        builder.reset()
                .setTitle("[search] Enter action")
                .addOption("[0-9]+", new MenuElement<>("[number]", s -> controller.selectSearchRecord(Integer.parseInt(s) - 1)))
                .addOption(new MenuElement<>("back", s -> controller.back()))
                .addOption(new MenuElement<>("again", s -> controller.again()));
    }

    public void buildListMenu(PhoneBookController controller) {
        builder.reset()
                .setTitle("[list] Enter action")
                .addOption("[0-9]+", new MenuElement<>("[number]", s -> controller.selectListRecord(Integer.parseInt(s) - 1)))
                .addOption(new MenuElement<>("back", s -> controller.back()));
    }

    public void buildEditPersonMenu(PhoneBookController controller) {
        builder.reset()
                .setTitle("Select a field")
                .addOption(new MenuElement<>("name",
                        s -> ((Person) controller.getCurrent()).setName(controller.getString("name"))))
                .addOption(new MenuElement<>("surname",
                        s -> ((Person) controller.getCurrent()).setSurname(controller.getString("surname"))))
                .addOption(new MenuElement<>("gender",
                        s -> ((Person) controller.getCurrent()).setGender(controller.getString("gender"))))
                .addOption(new MenuElement<>("birth",
                        s -> ((Person) controller.getCurrent()).setBirthDate(controller.getString("birth"))))
                .addOption(new MenuElement<>("number",
                        s -> (controller.getCurrent()).setPhoneNumber(controller.getString("number"))));
    }

    public void buildEditOrganizationMenu(PhoneBookController controller) {
        builder.reset()
                .setTitle("Select a field")
                .addOption(new MenuElement<>("name",
                        s -> ((Organization) controller.getCurrent()).setOrganizationName(controller.getString("organization name"))))
                .addOption(new MenuElement<>("address",
                        s -> ((Organization) controller.getCurrent()).setAddress(controller.getString("address"))))
                .addOption(new MenuElement<>("number",
                        s -> (controller.getCurrent()).setPhoneNumber(controller.getString("number"))));
    }

    public void buildRecordTypeMenu(PhoneBookController controller) {
        builder.reset()
                .setTitle("Enter the type")
                .addOption(new MenuElement<>("person",
                        s -> controller.addRecord(new Person(new KeyboardPersonProvider()))))
                .addOption(new MenuElement<>("organization",
                        s -> controller.addRecord(new Organization(new KeyboardOrganizationProvider()))));
    }


}
