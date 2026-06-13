package be.ehb.enterpriseappswalidoumass.repository;

import be.ehb.enterpriseappswalidoumass.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}