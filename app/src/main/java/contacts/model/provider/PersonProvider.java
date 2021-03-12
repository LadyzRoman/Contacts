package contacts.model.provider;

import contacts.model.Gender;

import java.time.LocalDate;


public interface PersonProvider extends RecordProvider {
    String getName();
    String getSurname();
    LocalDate getBirthDate();
    Gender getGender();
}
