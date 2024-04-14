package tu.sofia.travel.service;

import tu.sofia.travel.model.entity.Consumer;

public interface ConsumerService {
    Consumer getById(final Long id);

    Consumer updateAmount(
            final Long id,
            final Double ticketPrice
    );
}
