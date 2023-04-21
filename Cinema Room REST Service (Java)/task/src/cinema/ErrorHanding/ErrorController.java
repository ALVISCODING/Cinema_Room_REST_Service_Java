package cinema.ErrorHanding;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

/**
 * ErrorController is a Spring MVC controller advice class that handles exceptions thrown by any controller method in the application.
 * It provides centralized error handling logic and returns an appropriate error response to the client.
 * The @ControllerAdvice annotation is used to indicate that this class provides exception handling for all controllers in the application.
 */
@ControllerAdvice
public class ErrorController {
    //handling and returning an appropriate error response for this type of exception.
    @ExceptionHandler(ResponseStatusException.class)


    /**
     * Handles ResponseStatusException thrown by any controller method in the application.
     * It creates a new instance of ErrorDetails, sets the timestamp, HTTP status, error message, and custom message of the exception, and returns an ResponseEntity with the ErrorDetails instance and the HTTP status code of the exception.
     @param ex the ResponseStatusException to be handled
     @return a ResponseEntity with an ErrorDetails instance and the HTTP status code of the exception
     */
    public ResponseEntity<ErrorDetails> handleResponseStatusException(ResponseStatusException ex) {
        ErrorDetails errorResponse = new ErrorDetails();
        errorResponse.setTimestamp(LocalDateTime.now().toString());
        errorResponse.setStatus(ex.getRawStatusCode());
        errorResponse.setError(ex.getReason());
        errorResponse.setMessage(ex.getMessage());
        return ResponseEntity.status(ex.getRawStatusCode()).body(errorResponse);
    }

}
