package bai1;

public class PrepaidCard extends Ticket {

    public PrepaidCard(int value) {
        super(value);
    }

    @Override
    public void adjustValue(int amout) {
        debuct(amout);
    }

    @Override
    public boolean isValid() {
        return getValue() > 0;
    }

    @Override
    public void setValid(boolean valid) {

    }
}
