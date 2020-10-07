package bai2;

public class CurrentPlusAccount extends Account {

    private byte monthOfYear = 12;
    private double limitBalance;
    private float interestOfYear;
    private double fare;

    public CurrentPlusAccount(int id, double balance, double limitBalance, float interestOfYear, double fare) {
        super(id, balance);
        this.limitBalance = limitBalance;
        this.interestOfYear = interestOfYear;
    }

    public void clearCheck(double money) {
        super.setBalance(getBalance() - money - fare);
    }

    @Override
    void monthlyInterest() {
        if (getBalance() < limitBalance) {
            System.out.println("It hon so tien toi thieu nen khong co lai suat");
        }
        System.out.println(getBalance() * interestOfYear / monthOfYear);
    }
}
