package com.mjc813.contactjsp.DTO;

public interface IContact {
    public Integer getId();
    public void setId(Integer name);

    public String getName();
    public void setName(String name);

    public String getPhoneNumber();
    public void setPhoneNumber(String phoneNumber);

    public String getZipNumber();
    public void setZipNumber(String zipNumber);

    public String getEmail();
    public void setEmail(String email);

    public String getContactFullInfo();
}
