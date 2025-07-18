package com.nol.webcurd.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/member/")
    public String member() {
        return "/member/index";
    }
    @GetMapping("/member/add")
    public String add() {
        return "/member/add";
    }
}
