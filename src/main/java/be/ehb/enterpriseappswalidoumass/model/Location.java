package be.ehb.enterpriseappswalidoumass.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Naam van locatie is verplicht.")
    private String name;

    @NotBlank(message = "Adres is verplicht.")
    private String address;

    @Min(value = 1, message = "Capaciteit moet minstens 1 persoon zijn.")
    private int capacityPeople;

    public Location() {
    }

    public Location(String name, String address, int capacityPeople) {
        this.name = name;
        this.address = address;
        this.capacityPeople = capacityPeople;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacityPeople() {
        return capacityPeople;
    }

    public void setCapacityPeople(int capacityPeople) {
        this.capacityPeople = capacityPeople;
    }
}