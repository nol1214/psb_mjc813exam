package com.nol.springwebst.service;

import com.nol.springwebst.dto.Contact;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IContactMybatisMapper {
    public void insert(Contact contact);

    List<Contact> selectAll();

    Contact selectOne(Long id);

    void update(Contact contact);
}
