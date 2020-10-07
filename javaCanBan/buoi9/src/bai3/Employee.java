package bai3;

public class Employee extends StaffMember{

    public Employee(String name, String address, String phone, String socialNumber, double salary) {
        super(name, address, phone, socialNumber, salary);
    }

    @Override
    public void pay() {

    }

    @Override
    public void reward(double amount) {
        setSalary(getSalary()+amount);
    }
}
