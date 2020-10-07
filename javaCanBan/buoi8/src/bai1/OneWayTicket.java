package bai1;

public class OneWayTicket extends Ticket {
    private boolean valid = true;

    public OneWayTicket(int value) {
        super(value);
    }

    @Override
    public void adjustValue(int mount) {

    }

    @Override
    public boolean isValid() {
        return valid;
    }
}
