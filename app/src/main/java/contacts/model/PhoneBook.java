package contacts.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PhoneBook implements Serializable {
    private List<Record> records = new ArrayList<>();

    public PhoneBook() {
    }

    public void add(Record record) {
        records.add(record);
    }

    public void remove(int index) {
        records.remove(index);
    }

    public void remove(Record record) {
        records.remove(record);
    }

    public int getSize() {
        return records.size();
    }

    public List<Record> getRecords() {
        return new ArrayList<>(records);
    }

    public Stream<Record> records() {
        return records.stream();
    }

    public void edit(int index, Record record) {
        records.set(index, record);
    }

    public Record getRecord(int index) {
        return records.get(index);
    }
}
