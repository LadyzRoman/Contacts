package contacts.model;

import java.util.List;
import java.util.stream.Stream;

public interface PhoneBook {

    void add(Record record);

    void edit(int index, Record record);

    void remove(int index);

    void remove(Record record);

    List<Record> getRecords();

    Stream<Record> records();

    Record getRecord(int index);

    int getSize();
}
