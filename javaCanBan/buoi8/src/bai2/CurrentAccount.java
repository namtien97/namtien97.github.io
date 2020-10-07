package bai2;

public class CurrentAccount extends Account{
    private double fare;

    public CurrentAccount(int id,double balance,double fare) {
        super(id,balance);
        this.fare = fare;
    }

    public void clearCheck( double money){
        super.setBalance(getBalance()-money - fare);
    }

    @Override
    void monthlyInterest() {
        System.out.println("Khong co tien lai trong tai khoan nay!");
    }
}
