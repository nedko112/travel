package tu.sofia.travel.service;

import org.springframework.stereotype.Service;
import tu.sofia.travel.exception.DestinationNotFoundException;
import tu.sofia.travel.model.entity.Destination;
import tu.sofia.travel.repository.DestinationRepository;

@Service
public class DestinationServiceImpl
        implements DestinationService {

    private final DestinationRepository destinationRepository;

    public DestinationServiceImpl(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public Destination get(
            String departure,
            String destination
    ) {
        return this.destinationRepository.findDestinationByDepartureAndDestination(
                           departure,
                           destination
                   )
                                         .orElseThrow(DestinationNotFoundException::new);
    }
}
