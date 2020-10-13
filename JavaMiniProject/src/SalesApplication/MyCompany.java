package SalesApplication;

public class MyCompany extends CompanyInfo {
    private int goods;
    private double cash;

    public MyCompany(String taxId, String name, String phone, String address, int goods, double cash) {
        super(taxId, name, phone, address);
        this.goods = goods;
        this.cash = cash;
    }

    public void importGoods(int importGoods, double paidCash) {
        goods = +importGoods;
        cash = -paidCash;
    }

    public void saleGoods(int saleGoods, double customerCash) {
        goods = -saleGoods;
        cash = +customerCash;
    }

    public int getGoods() {
        return goods;
    }

    public void setGoods(int goods) {
        this.goods = goods;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
