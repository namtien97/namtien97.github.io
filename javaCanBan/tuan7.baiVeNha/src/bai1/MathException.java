package bai1;

public class MathException extends java.lang.Exception {
    private String message;

    public MathException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
