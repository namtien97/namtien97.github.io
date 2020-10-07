package bai4;

public abstract class RegisteredVehicle {
    private String tag;
    private String registeredTo;
    private String owner;

    public RegisteredVehicle(String tag, String registeredTo, String owner) {
        this.tag = tag;
        this.registeredTo = registeredTo;
        this.owner = owner;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getRegisteredTo() {
        return registeredTo;
    }

    public void setRegisteredTo(String registeredTo) {
        this.registeredTo = registeredTo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void reRegister(String registeredTo, String owner) {
        this.registeredTo = registeredTo;
        this.owner = owner;
    }

    public void printRegistration() {
        System.out.println("Tag: " + tag + "\n" +
                "Registered to: " + registeredTo + "\n" +
                "Owner: " + owner+"\n"
                +"-----------------------------------------------------");
    }

    public abstract double getAnnualFee();
}
