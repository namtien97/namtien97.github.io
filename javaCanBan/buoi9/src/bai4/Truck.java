package bai4;

public class Truck extends RegisteredMotorVehicle {
    private String truckType;
    private double annualFee;

    public Truck(String tag, String registeredTo, String owner, float emptyWeight, int lastOdometer, String truckType) {
        super(tag, registeredTo, owner, emptyWeight, lastOdometer);
        this.truckType = truckType;
    }

    public void printRegistration() {
        System.out.println("Tag: " + getTag() + "\n" +
                "Registered to: " + getRegisteredTo() + "\n" +
                "Owner: " + getOwner() + "\n" +
                "Empty weight: " + getEmptyWeight() + "\n" +
                "Last odo meter: " + getLastOdometer() + "\n" +
                "Annual fee: " + getAnnualFee()+"\n"+
                "Truck type: " +truckType+"\n"
                +"-----------------------------------------------------");
    }

    @Override
    public double getAnnualFee(){
        if (truckType.equals("BANTAI")){
            return annualFee = getEmptyWeight()*0.05;
        }else if(truckType.equals("CAMNHONG")){
            return annualFee = getEmptyWeight()*0.01;
        }
        return 0;
    }
}
