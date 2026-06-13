package be.ehb.enterpriseappswalidoumass.config;

import be.ehb.enterpriseappswalidoumass.model.Event;
import be.ehb.enterpriseappswalidoumass.model.Location;
import be.ehb.enterpriseappswalidoumass.repository.EventRepository;
import be.ehb.enterpriseappswalidoumass.repository.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedDatabase(EventRepository eventRepository, LocationRepository locationRepository) {
        return args -> {
            if (eventRepository.count() == 0 && locationRepository.count() == 0) {

                Location kaai = locationRepository.save(
                        new Location("Campus Kaai", "Nijverheidskaai 170, 1070 Anderlecht", 120)
                );

                Location buurthuis = locationRepository.save(
                        new Location("Buurthuis Scheut", "Ninoofsesteenweg 700, 1070 Anderlecht", 80)
                );

                Location kuregem = locationRepository.save(
                        new Location("Gemeenschapsruimte Kuregem", "Barastraat 120, 1070 Anderlecht", 60)
                );

                Location neerpede = locationRepository.save(
                        new Location("Neerpedezaal", "Neerpedestraat 250, 1070 Anderlecht", 100)
                );

                eventRepository.save(new Event(
                        LocalDateTime.now().plusDays(1),
                        "Warme maaltijdavond",
                        "Een gezellige avond waar buurtbewoners samen kunnen eten en elkaar ontmoeten.",
                        "Zwanze 1070",
                        "info@zwanze1070.be",
                        kaai
                ));

                eventRepository.save(new Event(
                        LocalDateTime.now().plusDays(2),
                        "Kledinginzameling",
                        "Inzameling van winterjassen, schoenen en warme kledij voor gezinnen in nood.",
                        "Zwanze 1070",
                        "kleding@zwanze1070.be",
                        buurthuis
                ));

                eventRepository.save(new Event(
                        LocalDateTime.now().plusDays(3),
                        "Buurtontbijt",
                        "Een laagdrempelig ontbijt voor buurtbewoners, vrijwilligers en lokale partners.",
                        "Partner Buurtwerking Anderlecht",
                        "contact@buurtwerking.be",
                        kuregem
                ));

                eventRepository.save(new Event(
                        LocalDateTime.now().plusDays(4),
                        "Studiehulp voor jongeren",
                        "Vrijwilligers helpen jongeren met huiswerk, planning en examenvoorbereiding.",
                        "Zwanze 1070",
                        "studiehulp@zwanze1070.be",
                        kaai
                ));

                eventRepository.save(new Event(
                        LocalDateTime.now().plusDays(5),
                        "Voedselpakketten verdelen",
                        "Verdeling van voedselpakketten aan gezinnen die tijdelijke ondersteuning nodig hebben.",
                        "Partner Solidair Brussel",
                        "hulp@solidairbrussel.be",
                        buurthuis
                ));

                eventRepository.save(new Event(
                        LocalDateTime.now().plusDays(6),
                        "Workshop budgetbeheer",
                        "Praktische workshop over omgaan met maandbudget, facturen en onverwachte kosten.",
                        "Zwanze 1070",
                        "budget@zwanze1070.be",
                        kuregem
                ));

                eventRepository.save(new Event(
                        LocalDateTime.now().plusDays(7),
                        "Vrijwilligersmeeting",
                        "Infomoment voor nieuwe vrijwilligers die zich willen inzetten in Anderlecht.",
                        "Zwanze 1070",
                        "vrijwilligers@zwanze1070.be",
                        neerpede
                ));

                eventRepository.save(new Event(
                        LocalDateTime.now().plusDays(8),
                        "Repair café",
                        "Buurtbewoners kunnen kleine toestellen, fietsen en kleding laten herstellen.",
                        "Partner Repair Brussels",
                        "repair@brussels.be",
                        neerpede
                ));

                eventRepository.save(new Event(
                        LocalDateTime.now().plusDays(9),
                        "Taalcafé Nederlands-Frans",
                        "Informele oefenmomenten voor buurtbewoners die Nederlands of Frans willen oefenen.",
                        "Zwanze 1070",
                        "taal@zwanze1070.be",
                        kaai
                ));

                eventRepository.save(new Event(
                        LocalDateTime.now().plusDays(10),
                        "Familiedag 1070",
                        "Een namiddag met activiteiten voor kinderen, ouders en grootouders uit de buurt.",
                        "Partner Gemeente Anderlecht",
                        "familiedag@anderlecht.be",
                        neerpede
                ));
            }
        };
    }
}