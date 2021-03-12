package contacts.model.provider;

public class KeyboardOrganizationProvider extends KeyboardRecordProvider implements OrganizationProvider {
    @Override
    public String getOrganizationName() {
        return getKeyboardString("Enter the organization name:");
    }

    @Override
    public String getAddress() {
        return getKeyboardString("Enter the address:");
    }
}
