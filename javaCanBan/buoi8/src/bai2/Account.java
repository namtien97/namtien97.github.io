package bai2;

public abstract class Account {
    private int id;
    private double balance;

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double money) {
        setBalance(getBalance() + money);
    }

    public void withdraw(double money) {
        if (money > getBalance()) throw
                new IllegalArgumentException("Vuot qua so tien ban co!");
        setBalance(getBalance() - money);
    }

    abstract void monthlyInterest();

}
