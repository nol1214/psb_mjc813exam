package org.example;

public class MjcValidCheck {
    public boolean isValidPhoneNumber(String text) {
        return text != null && text.matches("^010-\\d{4}-\\d{4}$");
    }

    public boolean isValidZipNumber(String text) {
        return text != null && text.matches("^[1-9]\\d{4}$");
    }

    public boolean isValidEmail(String text) {
        return text != null && text.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }
}
