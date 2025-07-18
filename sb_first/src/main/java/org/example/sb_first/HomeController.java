package org.example.sb_first;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/first")
    public String home(@RequestParam(required = false) Integer gugudan, Model model) {
        model.addAttribute("intro", "구구단 구구구단");

        if (gugudan != null && gugudan >= 1 && gugudan <= 9) {
            List<String> resultList = new ArrayList<>();
            for (int i = 1; i <= 9; i++) {
                resultList.add(gugudan + " x " + i + " = " + (gugudan * i));
            }
            model.addAttribute("gugudanList", resultList);
        }

        return "home";
    }
}

