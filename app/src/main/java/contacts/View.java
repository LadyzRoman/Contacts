package contacts;

import contacts.model.Record;
import menu.Menu;
import menu.MenuElement;

import java.util.List;

public interface View {
    void showMessage(String message);

    void showRecords(List<Record> list);

    void showRecordInfo(Record record);

    void showMenu(Menu<String> menu);

    String getString();

    String getString(String message);
}
