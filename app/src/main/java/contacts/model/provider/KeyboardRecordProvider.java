package contacts.model.provider;

import java.time.LocalDateTime;
import java.util.Scanner;

public class KeyboardRecordProvider implements RecordProvider {
    private final static Scanner scanner = new Scanner(System.in);

    protected String getKeyboardString(String message) {
        System.out.print(message + " ");
        return scanner.nextLine();
    }

    @Override
    public String getNumber() {
        return getKeyboardString("Enter the number:");
    }

    @Override
    public LocalDateTime getTimeCreated() {
        return LocalDateTime.now();
    }
}
