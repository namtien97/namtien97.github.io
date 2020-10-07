package bai4;

public class RegistrationException extends Exception{
    private String message;

    public RegistrationException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
