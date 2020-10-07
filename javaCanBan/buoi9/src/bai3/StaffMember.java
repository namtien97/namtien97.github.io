package bai3;

public abstract class StaffMember {
    private String name;
    private String address;
    private String phone;
    private String socialNumber;
    private double salary;

    public StaffMember(String name, String address, String phone, String socialNumber,
                       double salary) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.socialNumber = socialNumber;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getSocialNumber() {
        return socialNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract void pay();

    public abstract void reward(double amount);

    @Override
    public String toString() {
        return "Tên: " + name + "\n" + "Địa chỉ: " + address + "\n" + "Phone: " + phone +
                "\n" + "Số thẻ bảo hiểm xã hội: " + socialNumber + "\n" + "Phải trả: " + salary +
                "\n" + "-----------------------------------";
    }
}
