package org.example;

public class Main {
    public static void main(String[] args) {
        IContact contact = new ContactImp();
        contact.setName("이놀");
        contact.setPhoneNumber("010-1234-5678");
        contact.setZipNumber("12345");
        contact.setEmail("inol@example.com");

        System.out.println(contact);
    }
}
