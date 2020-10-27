package SalesApplication;

public class Customer extends CompanyInfo {
    private double transaction;

    public Customer(String taxId, String name, String phone, String address, double transaction) {
        super(taxId, name, phone, address);
        this.transaction = transaction;
    }

    public double getTransaction() {
        return transaction;
    }

    public void setTransaction(double transaction) {
        this.transaction = transaction;
    }

    public void increaseTrans(double totalBill) {
        transaction += totalBill;
    }

    @Override
    public String toString() {
        return "Ma so thue: " + super.getTaxId() +
                "\tTen: " + super.getName() +
                "\tSo dien thoai: " + super.getPhone() +
                "\t\tDia chi: " + super.getAddress() +
                "\tTong giao dich: " + transaction+" VND";
    }
}
