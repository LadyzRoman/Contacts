package contacts;

import contacts.model.Organization;
import contacts.model.Person;
import contacts.model.PhoneBook;
import contacts.model.Record;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneBookController {
    private PhoneBook model;
    private Main view;

    private Record current;
    private List<Record> searchResult = new ArrayList<>();

    private boolean back;

    public PhoneBookController(PhoneBook model, Main view) {
        this.model = model;
        this.view = view;
        this.back = false;
    }

    public void count() {
        view.printMessage(String.format("The Phone Book has %d records.", model.getSize()));
    }

    public void edit() {
        if (current instanceof Person) {
            view.showPersonEditMenu();
        } else if (current instanceof Organization) {
            view.showOrgEditMenu();

        }
        current.setTimeEdited(LocalDateTime.now());
        System.out.println("Saved");
        save();
    }

    public void addRecord(Record record) {
        model.add(record);
        save();
    }

    public void add() {
        view.addCertainRecord();
        view.printMessage("The record added!");
    }

    public void delete() {
        model.remove(current);
        searchResult.remove(current);
        back = true;
        save();
    }

    public void save() {
        //TODO Save to a file
    }

    public void load() {
        //TODO Load from file
    }

    public void list() {
        if (model.getSize() == 0) {
            view.printMessage("No records to list!");
        } else {
            view.printRecords(model.getRecords());
            view.showListMenu();
            back = false;
        }
    }

    public void search() {
        System.out.print("Enter search query: ");
        Scanner sc = new Scanner(System.in);
        var query = sc.nextLine();
        searchResult = model.getRecords().stream()
                .filter(r -> r.matches(query))
                .collect(Collectors.toList());
        while (!back) {
            view.printRecords(searchResult);
            view.showSearchMenu();
        }
        back = false;
    }

    public void selectSearchRecord(int index) {
        current = searchResult.get(index);
        while (!back) {
            view.showRecordInfo(current);
            view.showRecordMenu();
        }
    }

    public void selectListRecord(int index) {
        current = model.getRecord(index);
        while (!back) {
            view.showRecordInfo(current);
            view.showRecordMenu();
        }
    }

    public void exit() {
        view.setExit(true);
    }

    public Record getCurrent() {
        return current;
    }

    public String getString(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter " + message + ": ");
        return sc.nextLine();
    }

    public void back() {
        this.back = true;
    }

    public void again() {
        view.setRepeat(true);
        back = true;
    }
}
