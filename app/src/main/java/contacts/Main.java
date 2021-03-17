package contacts;

import contacts.controller.*;
import contacts.model.*;
import contacts.model.provider.impl.ConsoleDataProvider;
import contacts.model.provider.impl.ConsoleOrganizationProvider;
import contacts.model.provider.impl.ConsolePersonProvider;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleView(new ConsoleDataProvider());
        PhoneBook model = new ArrayListPhoneBook();

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
                new NewRecordController(
                        view,
                        model,
                        personProvider,
                        orgProvider
                )
        ).run();
    }
}
