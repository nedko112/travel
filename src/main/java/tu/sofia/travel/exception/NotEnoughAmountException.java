package tu.sofia.travel.exception;

import static tu.sofia.travel.model.constant.ErrorMessageConstants.NOT_ENOUGH_AMOUNT;

public class NotEnoughAmountException
        extends RuntimeException {
    public NotEnoughAmountException() {
        super(NOT_ENOUGH_AMOUNT);
    }
}