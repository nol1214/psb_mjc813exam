package com.nol.springwebst.dto;

public interface IContact {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String var1);

    String getPhoneNumber();
    void setPhoneNumber(String var1);

    String getZipNumber();
    void setZipNumber(String var1);

    String getEmail();
    void setEmail(String var1);

    default String getContactFullInfo() {
        return String.format("[ID:%d, 이름:%s, 전화번호:%s, ZIP:%s, Email:%s]"
                , this.getId()
                , this.getName()
                , this.getPhoneNumber()
                , this.getZipNumber()
                , this.getEmail()
        );
    }
}