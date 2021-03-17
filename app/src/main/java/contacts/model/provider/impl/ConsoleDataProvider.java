package contacts.model.provider.impl;

import contacts.model.provider.DataProvider;

import java.util.Scanner;

public class ConsoleDataProvider implements DataProvider {
    private Scanner sc = new Scanner(System.in);

    @Override
    public String getString(String message) {
        System.out.println(message);
        return sc.nextLine();
    }

    @Override
    public String getString() {
        return sc.nextLine();
    }
}
