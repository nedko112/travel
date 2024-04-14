package tu.sofia.travel.exception;

import static tu.sofia.travel.model.constant.ErrorMessageConstants.PRICE_NOT_FOUND;

public class PriceNotFoundException
        extends RuntimeException {
    public PriceNotFoundException() {
        super(PRICE_NOT_FOUND);
    }
}
