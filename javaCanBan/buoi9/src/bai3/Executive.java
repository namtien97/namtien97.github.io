package bai3;

public class Executive extends StaffMember {
    public Executive(String name, String address, String phone, String socialNumber, double salary) {
        super(name, address, phone, socialNumber, salary);
    }

    @Override
    public void pay() {
        setSalary(getSalary() + getSalary() * 0.1);
    }

    @Override
    public void reward(double amount) {
        setSalary(getSalary()+amount);
    }
}
