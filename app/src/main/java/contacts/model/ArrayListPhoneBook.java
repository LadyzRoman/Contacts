package contacts.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListPhoneBook implements PhoneBook, Serializable {
    private List<Record> records = new ArrayList<>();

    public ArrayListPhoneBook() {
    }

    @Override
    public void add(Record record) {
        records.add(record);
    }

    @Override
    public void remove(int index) {
        records.remove(index);
    }

    @Override
    public void remove(Record record) {
        records.remove(record);
    }

    @Override
    public void edit(int index, Record record) {
        records.set(index, record);
    }

    @Override
    public int getSize() {
        return records.size();
    }

    @Override
    public List<Record> getRecords() {
        return new ArrayList<>(records);
    }

    @Override
    public Stream<Record> records() {
        return records.stream();
    }

    @Override
    public Record getRecord(int index) {
        return records.get(index);
    }
}
