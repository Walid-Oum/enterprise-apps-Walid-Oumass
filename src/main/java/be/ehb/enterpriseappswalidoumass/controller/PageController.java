package be.ehb.enterpriseappswalidoumass.controller;

import be.ehb.enterpriseappswalidoumass.repository.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    private final EventRepository eventRepository;

    public PageController(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pageTitle", "Zwanze 1070");
        model.addAttribute("events", eventRepository.findTop10ByOrderByTimeDesc());
        return "index";
    }

}
