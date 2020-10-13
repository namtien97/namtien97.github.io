package SalesApplication;

public abstract class CompanyInfo {
    private String taxId;
    private String name;
    private String phone;
    private String address;

    public CompanyInfo(String taxId, String name, String phone, String address) {
        this.taxId = taxId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
