package tu.sofia.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tu.sofia.travel.model.entity.Destination;
import tu.sofia.travel.model.entity.Price;

import java.util.Optional;

public interface PriceRepository
        extends JpaRepository<Price, Long> {
    Optional<Price> findByDestination_DepartureAndDestination_Destination(
            final String departure,
            final String destination
    );
}
