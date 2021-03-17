package contacts.model;


import contacts.model.provider.RecordProvider;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Record implements Serializable {
    protected String phoneNumber;
    protected LocalDateTime timeCreated;
    protected LocalDateTime timeEdited;

    public Record() {
        this.timeCreated = LocalDateTime.now();
        this.timeEdited = timeCreated;
    }

    public Record(RecordProvider provider) {
        setPhoneNumber(provider.getNumber());
        this.timeCreated = provider.getTimeCreated();
        this.timeEdited = provider.getTimeCreated();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (validateNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "";
            System.out.println("Wrong number format!");
        }
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public LocalDateTime getTimeEdited() {
        return timeEdited;
    }

    public void setTimeEdited(LocalDateTime timeEdited) {
        this.timeEdited = timeEdited;
    }

    private boolean validateNumber(String phoneNumber) {
        String regex = "(\\+?\\([a-zA-Z0-9]+\\)([\\s\\-](([a-zA-Z0-9]{2,}[\\s\\-])*[a-zA-Z0-9]{2,}))?)" +
                "|(\\+?[a-zA-Z0-9]+([\\s\\-]\\([a-zA-Z0-9]{2,}\\))?([\\s\\-](([a-zA-Z0-9]{2,}[\\s\\-])*[a-zA-Z0-9]{2,}))?)";
        return phoneNumber.matches(regex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(phoneNumber, record.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    public String getInfo() {
        return "Number: " + (phoneNumber.equals("") ? "[no number]" : phoneNumber);
    }

    public boolean matches(String query) {
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        Matcher m = pattern.matcher(phoneNumber);

        return m.find();
    }
}
