package cinema.ErrorHanding;

import java.time.LocalDateTime;

/**
 * To encapsulates error details that can be returned as part of an API response.
 * It contains private instance variables for a timestamp, HTTP status code, error message, and a custom error message.
 * The instance variables can be accessed via getter and setter methods.
 */
public class ErrorDetails {

    private String timestamp;
    private int status;
    private String error;
    private String message;

    public ErrorDetails() {
    }

    public ErrorDetails(String timestamp, int status, String error, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

