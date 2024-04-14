package tu.sofia.travel.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tu.sofia.travel.exception.*;
import tu.sofia.travel.model.payload.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            {
                    DestinationNotFoundException.class,
                    PriceNotFoundException.class,
                    TicketNotFoundException.class,
                    ConsumerNotFoundException.class
            }
    )
    public ResponseEntity<ErrorResponse> returnNotFound(final Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(this.generateResponse(ex));
    }

    @ExceptionHandler(NotEnoughAmountException.class)
    public ResponseEntity<ErrorResponse> returnBadRequest(final Exception ex) {
        return ResponseEntity.status(HttpStatusCode.valueOf(400))
                             .body(this.generateResponse(ex));
    }

    @ExceptionHandler(UserNotAuthenticatedException.class)
    public ResponseEntity<ErrorResponse> returnUnauthenticated(final Exception ex) {
        return ResponseEntity.status(HttpStatusCode.valueOf(401))
                             .body(this.generateResponse(ex));
    }

    private ErrorResponse generateResponse(final Exception ex) {
        return new ErrorResponse(
                ex.getClass()
                  .getSimpleName(),
                ex.getMessage()
        );
    }
}
