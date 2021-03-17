package contacts;

import contacts.model.Record;
import contacts.model.provider.DataProvider;
import menu.Menu;

import java.util.List;

public class ConsoleView implements View{
    private DataProvider dataProvider;

    public ConsoleView(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
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
