package be.ehb.enterpriseappswalidoumass.controller;

import be.ehb.enterpriseappswalidoumass.model.Event;
import be.ehb.enterpriseappswalidoumass.repository.EventRepository;
import be.ehb.enterpriseappswalidoumass.repository.LocationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
