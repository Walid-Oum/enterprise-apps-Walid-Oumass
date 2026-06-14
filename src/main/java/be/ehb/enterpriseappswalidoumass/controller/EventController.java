package be.ehb.enterpriseappswalidoumass.controller;

import be.ehb.enterpriseappswalidoumass.model.Event;
import be.ehb.enterpriseappswalidoumass.repository.EventRepository;
import be.ehb.enterpriseappswalidoumass.repository.LocationRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public EventController(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @GetMapping("/{id}")
    public String details(@PathVariable Long id,  Model model){

        Event event = eventRepository.findById(id).orElseThrow(()->new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "evenement niet gevonden"
        ));
        model.addAttribute("event", event);
        model.addAttribute("pageTitle", event.getTitle());
        return "event-details";

    }

    @GetMapping("/new")
    public String newEventForm(Model model){
        model.addAttribute("pageTitle", "Nieuw Evenement");
        model.addAttribute("event", new Event());
        //voor dropdown opties
        model.addAttribute("locations", locationRepository.findAll());
        return "new-event";
    }


    @PostMapping("/new")
    public String saveNewEvent(
            @Valid @ModelAttribute("event") Event event,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Nieuw evenement");
            model.addAttribute("locations", locationRepository.findAll());
            return "new-event";
        }

        eventRepository.save(event);
        return "redirect:/";
    }
}
