package be.ehb.enterpriseappswalidoumass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pageTitle", "Zwanze 1070");
        return "index";
    }
}
