package tu.sofia.travel.exception;

import static tu.sofia.travel.model.constant.ErrorMessageConstants.TICKET_NOT_FOUND;

public class TicketNotFoundException
        extends RuntimeException {
    public TicketNotFoundException() {
        super(TICKET_NOT_FOUND);
    }
}