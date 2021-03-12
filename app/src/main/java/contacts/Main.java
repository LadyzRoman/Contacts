package contacts;

import contacts.model.*;
import contacts.model.Record;
import menu.MenuElement;
import menu.MenuException;
import menu.impl.StringKeyMenu;

import java.util.List;
import java.util.Scanner;

public class Main {
    private PhoneBook model = new PhoneBook();
    private PhoneBookController controller = new PhoneBookController(model, this);

    private StringKeyMenu mainMenu;
    private StringKeyMenu personTypeMenu;
    private StringKeyMenu orgEditMenu;
    private StringKeyMenu personEditMenu;
    private StringKeyMenu recordMenu;
    private StringKeyMenu searchMenu;
    private StringKeyMenu listMenu;

    private boolean exit;
    private boolean repeat;

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
        main.mainMenuLoop();
    }

    public void mainMenuLoop() {
        Scanner sc = new Scanner(System.in);
        String option = null;
        while (!exit) {
            try {
                if (!repeat) {
                    mainMenu.print();
                    option = sc.nextLine();
                }
                repeat = false;
                MenuElement<String> action = mainMenu.getAction(option);
                action.execute(option);
            } catch (MenuException e) {
                System.out.println("Wrong option");
            }
            System.out.println();
        }
    }

    public void init() {
        var builder = StringKeyMenu.getBuilder();
        var director = new MenuDirector(builder);
        director.buildMainMenu(controller);
        mainMenu = builder.build();
        director.buildEditPersonMenu(controller);
        personEditMenu = builder.build();
        director.buildEditOrganizationMenu(controller);
        orgEditMenu = builder.build();
        director.buildRecordTypeMenu(controller);
        personTypeMenu = builder.build();
        director.buildRecordMenu(controller);
        recordMenu = builder.build();
        director.buildSearchMenu(controller);
        searchMenu = builder.build();
        director.buildListMenu(controller);
        listMenu = builder.build();
    }



    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printRecords(List<Record> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, list.get(i));
        }
        System.out.println();
    }

    public void showOrgEditMenu() {
        showMenu(orgEditMenu);
    }

    public void showPersonEditMenu() {
        showMenu(personEditMenu);
    }

    public void addCertainRecord() {
        showMenu(personTypeMenu);
    }

    public void showRecordMenu() {
        showMenu(recordMenu);
    }

    public void showSearchMenu() {
        showMenu(searchMenu);
    }

    public void showListMenu() {
        showMenu(listMenu);
    }

    public void showRecordInfo(Record record) {
        System.out.println(record.getInfo());
        System.out.println();
    }

    public void showMenu(StringKeyMenu menu) {
        Scanner sc = new Scanner(System.in);
        boolean rightOption = false;
        while (!rightOption) {
            try {
                menu.print();
                String option = sc.nextLine();
                var action = menu.getAction(option);
                action.execute(option);
                rightOption = true;
            } catch (MenuException e) {
                System.out.println("Wrong option");
            }
        }
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }
}
