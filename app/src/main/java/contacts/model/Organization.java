package contacts.model;

import contacts.model.provider.OrganizationProvider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Organization extends Record {
    private String organizationName;
    private String address;

    public Organization(OrganizationProvider provider) {
        super(provider);
        this.organizationName = provider.getOrganizationName();
        this.address = provider.getAddress();
        this.timeCreated = provider.getTimeCreated();
        this.timeEdited = timeCreated;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return organizationName;
    }

    @Override
    public String getInfo() {
        return "Organization name: " + organizationName + '\n' +
                "Address: " + address + '\n' +
                "Number: " + (phoneNumber.equals("") ? "[no number]" : phoneNumber) + '\n' +
                "Time created: " + timeCreated + '\n' +
                "Time last edit: " + timeEdited;
    }

    @Override
    public boolean matches(String query) {
        Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
        String sequence = organizationName + address;
        Matcher m = pattern.matcher(sequence);

        return m.find() || super.matches(query);
    }
}
