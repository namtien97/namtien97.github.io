package exception.user_defined;

public class InvalidAgeException extends Exception {
    private String message;


    public InvalidAgeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
