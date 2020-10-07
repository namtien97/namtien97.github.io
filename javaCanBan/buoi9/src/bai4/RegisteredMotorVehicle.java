package bai4;

public class RegisteredMotorVehicle extends RegisteredVehicle {
    private float emptyWeight;
    private int lastOdometer;
    private double annualFee;

    public RegisteredMotorVehicle(String tag, String registeredTo, String owner, float emptyWeight, int lastOdometer) {
        super(tag, registeredTo, owner);
        this.emptyWeight = emptyWeight;
        this.lastOdometer = lastOdometer;
    }

    public float getEmptyWeight() {
        return emptyWeight;
    }

    public int getLastOdometer() {
        return lastOdometer;
    }

    public void printRegistration() {
        System.out.println("Tag: " + getTag() + "\n" +
                "Registered to: " + getRegisteredTo() + "\n" +
                "Owner: " + getOwner() + "\n" +
                "Empty weight: " + getEmptyWeight() + "\n" +
                "Last odo meter: " + getLastOdometer() + "\n" +
                "Annual fee" + getAnnualFee()+"\n"
                +"-----------------------------------------------------");
    }

    public void reRegister(String registeredTo, String owner, int lastOdometer) throws RegistrationException {
        super.setOwner(owner);
        super.setRegisteredTo(registeredTo);
        if(lastOdometer < getLastOdometer()){
            throw new RegistrationException("Last odo meter must be greater last odo meter last time");
        }else{
            this.lastOdometer = lastOdometer;
        }
    }

    @Override
    public double getAnnualFee() {
        return annualFee = (double) (emptyWeight * 0.1);
    }
}
