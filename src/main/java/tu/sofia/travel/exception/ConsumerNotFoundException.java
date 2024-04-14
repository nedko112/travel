package tu.sofia.travel.exception;

import static tu.sofia.travel.model.constant.ErrorMessageConstants.USER_NOT_FOUND;

public class ConsumerNotFoundException
        extends RuntimeException {
    public ConsumerNotFoundException() {
        super(USER_NOT_FOUND);
    }
}
