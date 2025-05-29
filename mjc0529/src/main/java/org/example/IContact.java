package org.example;

public interface IContact {
    void setName(String name);
    void setPhoneNumber(String phoneNumber);
    void setZipNumber(String zipNumber);
    void setEmail(String email);

    String getName();
    String getPhoneNumber();
    String getZipNumber();
    String getEmail();

    boolean isValidPhoneNumber(String phoneNumber);
    boolean isValidZipNumber(String zipNumber);
    boolean isValidEmail(String email);

    String getContactFullInfo();
}