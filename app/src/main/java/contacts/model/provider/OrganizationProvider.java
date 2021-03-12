package contacts.model.provider;

public interface OrganizationProvider extends RecordProvider {
    String getOrganizationName();
    String getAddress();
}
