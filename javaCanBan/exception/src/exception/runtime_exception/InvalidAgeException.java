package exception.runtime_exception;

public class InvalidAgeException extends RuntimeException {
    private String message;

    public InvalidAgeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
