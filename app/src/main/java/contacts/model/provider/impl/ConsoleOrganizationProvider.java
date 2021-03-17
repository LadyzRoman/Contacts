package contacts.model.provider.impl;

import contacts.model.provider.OrganizationProvider;

public class ConsoleOrganizationProvider extends ConsoleRecordProvider implements OrganizationProvider {
    @Override
    public String getOrganizationName() {
        return getString("Enter the organization name:");
    }

    @Override
    public String getAddress() {
        return getString("Enter the address:");
    }
}
