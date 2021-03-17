package contacts;

import contacts.controller.*;
import contacts.model.*;
import contacts.model.Record;
import contacts.model.provider.DataProvider;
import contacts.model.provider.impl.ConsoleDataProvider;
import contacts.model.provider.impl.ConsoleOrganizationProvider;
import contacts.model.provider.impl.ConsolePersonProvider;
import menu.Menu;

import java.util.List;

public class Main implements View {
    private DataProvider dataProvider;

    public Main(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public static void main(String[] args) {
        Main view = new Main(new ConsoleDataProvider());
        PhoneBook model = new PhoneBook();

        ConsolePersonProvider personProvider = new ConsolePersonProvider();
        ConsoleOrganizationProvider orgProvider = new ConsoleOrganizationProvider();
        PersonController personController = new PersonController(
                view,
                model,
                personProvider
        );
        OrganizationController organizationController = new OrganizationController(
                view,
                model,
                orgProvider
        );
        new PhoneBookController(
                view,
                model,
                new ListController(
                        view,
                        model,
                        personController,
                        organizationController
                ),
                new SearchController(
                        view,
                        model,
                        personController,
                        organizationController
                ),
                personProvider,
                orgProvider
        ).run();
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showRecords(List<Record> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, list.get(i));
        }
        System.out.println();
    }

    @Override
    public void showRecordInfo(Record record) {
        System.out.println(record.getInfo());
        System.out.println();
    }

    @Override
    public void showMenu(Menu<String> menu) {
        menu.print();
    }

    @Override
    public String getString() {
        return dataProvider.getString();
    }

    @Override
    public String getString(String message) {
        return dataProvider.getString(message);
    }
}
