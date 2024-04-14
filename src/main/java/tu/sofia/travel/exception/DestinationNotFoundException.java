package tu.sofia.travel.exception;

import static tu.sofia.travel.model.constant.ErrorMessageConstants.DESTINATION_NOT_FOUND;

public class DestinationNotFoundException
        extends RuntimeException {
    public DestinationNotFoundException() {
        super(DESTINATION_NOT_FOUND);
    }
}