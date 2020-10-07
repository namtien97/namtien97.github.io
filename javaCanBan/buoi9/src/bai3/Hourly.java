package bai3;

public class Hourly extends StaffMember {
    private double time;

    public Hourly(String name, String address, String phone, String socialNumber, double salary, double time) {
        super(name, address, phone, socialNumber, salary);
        this.time = time;
    }

    @Override
    public void pay() {
        setSalary(getSalary() * time);
    }

    @Override
    public void reward(double amount) {

    }

    @Override
    public String toString() {
        return "Tên: " + getName() + "\n" + "Địa chỉ: " + getAddress() + "\n" + "Phone: " + getPhone() +
                "\n" + "Số thẻ bảo hiểm xã hội: " + getSocialNumber() + "\n" + "Số giờ làm việc: " + time + "\n" + "Phải trả: " + getSalary() +
                "\n" + "-----------------------------------";
    }
}
