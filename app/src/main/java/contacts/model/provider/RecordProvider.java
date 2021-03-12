package contacts.model.provider;

import java.time.LocalDateTime;

public interface RecordProvider {
    String getNumber();
    LocalDateTime getTimeCreated();
}
