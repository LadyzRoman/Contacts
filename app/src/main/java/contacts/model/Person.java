package contacts.model;

import contacts.model.provider.PersonProvider;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person extends Record {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private Gender gender;

    public Person(PersonProvider provider) {
        this.name = provider.getName();
        this.surname = provider.getSurname();
        try {
            this.birthDate = provider.getBirthDate();
        } catch (DateTimeParseException e) {
            System.out.println("Bad birth date!");
        }

        try {
            this.gender = provider.getGender();
        } catch (IllegalArgumentException e) {
            System.out.println("Bad gender!");
        }
        setPhoneNumber(provider.getNumber());
        this.timeCreated = provider.getTimeCreated();
        this.timeEdited = timeCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setGender(String gender) {
        try {
            this.gender = Gender.valueOf(gender);
        } catch (IllegalArgumentException e) {
            System.out.println("Bad gender!");
        }
    }

    public void setBirthDate(String birth) {
        try {
            this.birthDate = LocalDate.parse(birth);
        } catch (DateTimeParseException e) {
            System.out.println("Bad birth date!");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, surname);
    }

    @Override
    public String getInfo() {
        return "Name: " + name + '\n' +
                "Surname: " + surname + '\n' +
                "Birth date: " + (birthDate == null ? "[no data]" : birthDate) + '\n' +
                "Gender: " + (gender == null ? "[no data]" : gender) + '\n' +
                "Number: " + (phoneNumber.equals("") ? "[no number]" : phoneNumber) + '\n' +
                "Time created: " + timeCreated + '\n' +
                "Time last edit: " + timeEdited;
    }

    @Override
    public boolean matches(String query) {
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        String sequence = name + surname + birthDate + gender;
        Matcher m = pattern.matcher(sequence);

        return m.find() || super.matches(query);
    }
}
