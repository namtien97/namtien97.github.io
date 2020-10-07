import java.util.Date;

public class Accout {
    final byte MONTH_OF_YEAR = 12;

    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    Accout (){
    }

    Accout (int id, double balance){
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate(){
        return annualInterestRate/MONTH_OF_YEAR;
    }

    public double getMonthlyInterest(int years){
        int numberOfPayment = years * MONTH_OF_YEAR;
        return getBalance() * getMonthlyInterestRate() * Math.pow(1+getMonthlyInterestRate(),numberOfPayment)/(Math.pow(1+getMonthlyInterestRate(),numberOfPayment)-1);
    }

    public double withdraw(double withdrawMoney){
        return getBalance() - withdrawMoney;
    }

    public double deposit(double topUpMoney){
        return getBalance() + topUpMoney;
    }
}
