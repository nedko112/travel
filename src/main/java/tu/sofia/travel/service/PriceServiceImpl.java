package tu.sofia.travel.service;

import org.springframework.stereotype.Service;
import tu.sofia.travel.exception.PriceNotFoundException;
import tu.sofia.travel.model.entity.Price;
import tu.sofia.travel.repository.PriceRepository;

@Service
public class PriceServiceImpl
        implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price getPriceByDepartureData(
            String departure,
            String destination
    ) {
        return this.priceRepository.findByDestination_DepartureAndDestination_Destination(
                departure,
                destination
        ).orElseThrow(PriceNotFoundException::new);

    }
}
