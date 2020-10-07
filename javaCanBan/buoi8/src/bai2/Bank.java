package bai2;

public class Bank {
    public static void main(String[] args) {
        var savingsAccount1 = new SavingsAccount(1, 10000, 7);
        savingsAccount1.monthlyInterest();
        var currentAccout1 = new CurrentAccount(2,1000,10);
        currentAccout1.clearCheck(100);
        System.out.println(currentAccout1.getBalance());
    }
}
