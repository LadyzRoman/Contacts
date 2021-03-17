package contacts.model.provider.impl;

import contacts.model.Gender;
import contacts.model.provider.PersonProvider;

import java.time.LocalDate;

public class ConsolePersonProvider extends ConsoleRecordProvider implements PersonProvider {

    @Override
    public String getName() {
        return getString("Enter the name:");
    }

    @Override
    public String getSurname() {
        return getString("Enter the surname:");
    }

    @Override
    public LocalDate getBirthDate() {
        return LocalDate.parse(getString("Enter the birth date:"));
    }

    @Override
    public Gender getGender() {
        return Gender.valueOf(getString("Enter the gender (M, F):"));
    }
}
