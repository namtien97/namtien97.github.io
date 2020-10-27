package SalesApplication;

public class Supplier extends CompanyInfo {
    private double supplierTrans;

    public Supplier(String taxId, String name, String phone, String address, double supplierTrans) {
        super(taxId, name, phone, address);
        this.supplierTrans = supplierTrans;
    }

    public double getSupplierTrans() {
        return supplierTrans;
    }

    public void setSupplierTrans(double supplierTrans) {
        this.supplierTrans = supplierTrans;
    }

    public void increaseTrans(double totalBill) {
        supplierTrans += totalBill;
    }

    @Override
    public String toString() {
        return "Ma so thue: " + super.getTaxId() +
                "\tTen: " + super.getName() +
                "\tSo dien thoai: " + super.getPhone() +
                "\t\tDia chi: " + super.getAddress() +
                "\tTong giao dich: " + supplierTrans+" VND";
    }
}
