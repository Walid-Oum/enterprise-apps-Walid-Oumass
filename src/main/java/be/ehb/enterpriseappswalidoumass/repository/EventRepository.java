package be.ehb.enterpriseappswalidoumass.repository;

import be.ehb.enterpriseappswalidoumass.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findTop10ByOrderByTimeDesc();
}