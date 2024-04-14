package tu.sofia.travel.exception;

import static tu.sofia.travel.model.constant.ErrorMessageConstants.USER_NOT_AUTHENTICATED;

public class UserNotAuthenticatedException
        extends RuntimeException {
    public UserNotAuthenticatedException() {
        super(USER_NOT_AUTHENTICATED);
    }
}