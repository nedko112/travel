package tu.sofia.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tu.sofia.travel.model.entity.Destination;

import java.util.Optional;

public interface DestinationRepository
        extends JpaRepository<Destination, Long> {
    Optional<Destination> findDestinationByDepartureAndDestination(
            final String departure,
            final String destination
    );
}