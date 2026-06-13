package be.ehb.enterpriseappswalidoumass.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Tijdstip is verplicht.")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime time;

    @NotBlank(message = "Titel is verplicht.")
    private String title;

    @NotBlank(message = "Omschrijving is verplicht.")
    @Column(length = 1000)
    private String description;

    @NotBlank(message = "Organisatie is verplicht.")
    private String organisation;

    @NotBlank(message = "E-mailadres is verplicht.")
    @Email(message = "Geef een geldig e-mailadres in.")
    private String contactEmail;

    @NotNull(message = "Locatie is verplicht.")
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Event() {
    }

    public Event(LocalDateTime time, String title, String description, String organisation, String contactEmail, Location location) {
        this.time = time;
        this.title = title;
        this.description = description;
        this.organisation = organisation;
        this.contactEmail = contactEmail;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}