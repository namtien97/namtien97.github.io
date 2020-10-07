package bai4;

public class RegisteredVehicleTest {
    public static void main(String[] args) {
        RegisteredVehicle[] registeredVehicle = {new Truck("A", "Nguyen Nam", "Ha Nam", 2.5f, 0, "CAMNHONG")};
        registeredVehicle[0].printRegistration();
    }
}
