package com.nol.springwebst.service;

import com.nol.springwebst.dto.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private IContactMybatisMapper contactMapper;

    @GetMapping("/add")
    public String addView() {
        return "contact/add";
    }

    @PostMapping("/addconfirm")
    public String addConfirm(@ModelAttribute Contact inputContact) {
        try {
            System.out.printf("DB insert 전 : %s\n", inputContact);
            contactMapper.insert(inputContact);
            System.out.printf("DB insert 후 : %s\n", inputContact);
        } catch (Throwable e) {
            System.out.println("Insert 오류: " + e.toString());
        }
        return "redirect:/contact/contactlist";
    }

    @GetMapping("/contactlist")
    public String selectAll(Model model) {
        try {
            List<Contact> contacts = contactMapper.selectAll();
            model.addAttribute("contacts", contacts);
        } catch (Throwable e) {
            System.out.println("selectAll 오류: " + e.toString());
        }
        return "contact/list";
    }

    @GetMapping("/view")
    public String view(@RequestParam("id") Long id, Model model) {
        try {
            Contact result = contactMapper.selectOne(id);
            model.addAttribute("contact", result);
        } catch (Throwable e) {
            System.out.println("selectOne 오류: " + e.toString());
        }
        return "contact/view";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam("id") Long id, Model model) {
        try {
            Contact result = contactMapper.selectOne(id);
            model.addAttribute("dto", result);
        } catch (Throwable e) {
            System.out.println("modify 오류: " + e.toString());
        }
        return "contact/modify";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Contact dto) {
        try {
            contactMapper.update(dto);
        } catch (Throwable e) {
            System.out.println("update 오류: " + e.toString());
        }
        return "redirect:/contact/contactlist";
    }
}
