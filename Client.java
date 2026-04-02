package CRMS;

public class Client {
    private int clientId;
    private String name;
    private LicenseDetails licenseDetails;
    private ContactDetails contactDetails;

    public Client(int clientId, String name, LicenseDetails licenseDetails, ContactDetails contactDetails) {
        this.clientId = clientId;
        this.name = name;
        this.licenseDetails = licenseDetails;
        this.contactDetails = contactDetails;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public LicenseDetails getLicenseDetails() {
        return licenseDetails;
    }

    public void setLicenseDetails(LicenseDetails licenseDetails) {
        this.licenseDetails = licenseDetails;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", licenseDetails=" + licenseDetails +
                ", contactDetails=" + contactDetails +
                '}';
    }
}
