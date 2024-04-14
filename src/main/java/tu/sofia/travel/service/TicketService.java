package tu.sofia.travel.service;

import tu.sofia.travel.model.payload.TicketRequest;

public interface TicketService {
    Double create(
            final TicketRequest ticketRequest,
            final Long userId
    );
}
