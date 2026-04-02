package CRMS;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class LicenseDetails {
    private String licenseNumber;
    private String validUntil;   
    private String restrictions;

    public LicenseDetails(String licenseNumber, String validUntil, String restrictions) {
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

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public boolean isValid() {
        try {
            LocalDate expiryDate = LocalDate.parse(validUntil);
            return !expiryDate.isBefore(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public LocalDate getValidUntilAsDate() {
        return LocalDate.parse(validUntil);
    }

    @Override
    public String toString() {
        return "LicenseDetails{" +
                "licenseNumber='" + licenseNumber + '\'' +
                ", validUntil='" + validUntil + '\'' +
                ", restrictions='" + restrictions + '\'' +
                '}';
    }
}
