package tu.sofia.travel.service;

import tu.sofia.travel.model.entity.Price;

public interface PriceService {
    Price getPriceByDepartureData(
            String departure,
            String destination
    );
}
