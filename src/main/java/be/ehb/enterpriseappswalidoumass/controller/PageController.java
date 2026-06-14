package be.ehb.enterpriseappswalidoumass.controller;

import be.ehb.enterpriseappswalidoumass.repository.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    private final EventRepository eventRepository;

    public PageController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pageTitle", "Zwanze 1070");
        model.addAttribute("events", eventRepository.findTop10ByOrderByTimeDesc());
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "Over Zwanze 1070");
        return "about";
    }


    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("pageTitle", "Contact");
        model.addAttribute("sent", false);
        return "contact";
    }

    @PostMapping("/contact")
    public String sendContactMessage(@RequestParam String name, @RequestParam String email, @RequestParam String subject, @RequestParam String message, Model model) {
        model.addAttribute("pageTitle", "Contact");
        model.addAttribute("sent", true);
        model.addAttribute("name", name);

        return "contact";
    }

}
