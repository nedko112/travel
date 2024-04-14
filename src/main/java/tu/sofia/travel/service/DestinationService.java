package tu.sofia.travel.service;

import tu.sofia.travel.model.entity.Destination;

public interface DestinationService {
    Destination get(
            final String departure,
            final String destination
    );
}