package bai2;

public class SavingsAccount extends Account {
    final byte monthOfYear = 12;
    private float interestOfYear;
    private double monthlyInterest;

    public SavingsAccount(int id, double balance, float interestOfYear) {
        super(id,balance);
        this.interestOfYear = interestOfYear;
    }

    public float getInterestOfYear() {
        return interestOfYear;
    }

    @Override
    void monthlyInterest() {
        System.out.println(monthlyInterest = getBalance() * getInterestOfYear() / monthOfYear);
    }
}
