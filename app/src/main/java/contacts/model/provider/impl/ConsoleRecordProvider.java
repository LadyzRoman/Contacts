package contacts.model.provider.impl;

import contacts.model.provider.RecordProvider;

import java.time.LocalDateTime;

public class ConsoleRecordProvider extends ConsoleDataProvider implements RecordProvider  {
    @Override
    public String getNumber() {
        return getString("Enter the number:");
    }

    @Override
    public LocalDateTime getTimeCreated() {
        return LocalDateTime.now();
    }
}
