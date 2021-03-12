package contacts.model.provider;

import contacts.model.Gender;

import java.time.LocalDate;

public class KeyboardPersonProvider extends KeyboardRecordProvider implements PersonProvider {

    @Override
    public String getName() {
        return getKeyboardString("Enter the name:");
    }

    @Override
    public String getSurname() {
        return getKeyboardString("Enter the surname:");
    }

    @Override
    public LocalDate getBirthDate() {
        return LocalDate.parse(getKeyboardString("Enter the birth date:"));
    }

    @Override
    public Gender getGender() {
        return Gender.valueOf(getKeyboardString("Enter the gender (M, F):"));
    }
}
