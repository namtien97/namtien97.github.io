package bai1;

public abstract class Ticket {

    private int value;
    private Gate origin;
    private boolean valid = true;

    public Ticket(int value) {
        this.value = value;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public abstract void adjustValue(int amout);

    public abstract boolean isValid();

    public int debuct(int amout) {
        return value -= amout;
    }

    public void setOrigin(Gate origin) {
        if (origin == null) {
            this.origin = null;
        } else {
            this.origin = origin;
        }
    }

    public Gate getOrigin() {
        return origin;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Ticket " + value + "\n" + "Status: " + valid;
    }

}
