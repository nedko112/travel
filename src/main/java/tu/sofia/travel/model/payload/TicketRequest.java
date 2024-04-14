package tu.sofia.travel.model.payload;

import java.time.LocalTime;

public record TicketRequest(
        String departure,
        String destination,
        LocalTime departureFrom,
        LocalTime arriveAt,
        Boolean hasKid,
        Boolean hasFamilyCard,
        Boolean hasAdultCard
) {
}
