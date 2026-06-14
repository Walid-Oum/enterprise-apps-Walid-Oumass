package be.ehb.enterpriseappswalidoumass.controller;

import be.ehb.enterpriseappswalidoumass.repository.EventRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    private final EventRepository eventRepository;
    private final JavaMailSender mailSender;

    @Value("${app.mail.to}")
    private String adminEmail;

    public PageController(EventRepository eventRepository, JavaMailSender mailSender) {
        this.eventRepository = eventRepository;
        this.mailSender = mailSender;
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
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(adminEmail);
        mailMessage.setReplyTo(email);
        mailMessage.setSubject("Contactformulier Zwanze 1070: " + subject);
        mailMessage.setText("Naam: " + name + "\n" + "E-mail: " + email + "\n\n" + "Bericht:\n" + message);

        mailSender.send(mailMessage);

        model.addAttribute("pageTitle", "Contact");
        model.addAttribute("sent", true);
        model.addAttribute("name", name);

        return "contact";
    }

}
