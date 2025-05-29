package org.example;

public class ContactImp implements IContact {
    private String name, phone, zip, email;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) this.phone = phoneNumber;
    }

    @Override
    public void setZipNumber(String zipNumber) {
        if (isValidZipNumber(zipNumber)) this.zip = zipNumber;
    }

    @Override
    public void setEmail(String email) {
        if (isValidEmail(email)) this.email = email;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getPhoneNumber() { return phone; }

    @Override
    public String getZipNumber() { return zip; }

    @Override
    public String getEmail() { return email; }

    @Override
    public boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\d{3}-\\d{3,4}-\\d{4}");
    }

    @Override
    public boolean isValidZipNumber(String zipNumber) {
        return zipNumber != null && zipNumber.matches("\\d{5}");
    }

    @Override
    public boolean isValidEmail(String email) {
        return email != null && email.matches("^\\S+@\\S+\\.\\S+$");
    }

    @Override
    public String getContactFullInfo() {
        return String.format("이름: %s\n폰번호: %s\n우편번호: %s\n이메일: %s", name, phone, zip, email);
    }

    @Override
    public String toString() {
        return getContactFullInfo();
    }
}
