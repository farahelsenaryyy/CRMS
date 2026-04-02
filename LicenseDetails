package CRMS;
import java.time.LocalDate;

public class LicenseDetails {
    private String licenseNumber;
    private LocalDate validUntil;
    private String restrictions;

    public LicenseDetails(String licenseNumber, LocalDate validUntil, String restrictions) {
        this.licenseNumber = licenseNumber;
        this.validUntil = validUntil;
        this.restrictions = restrictions;
    }
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public boolean isValid() {
        return validUntil != null && !validUntil.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return "LicenseDetails{" +
                "licenseNumber='" + licenseNumber + '\'' +
                ", validUntil=" + validUntil +
                ", restrictions='" + restrictions + '\'' +
                '}';
    }
}
