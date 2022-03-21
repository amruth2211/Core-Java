package Interfaces;

interface RBI {
    static double rateOfInterest = 0.04;

    void showBalance();

    double withdraw(double amount);

    double deposit(double amount);

    double calculateYearlyInterest();
}

class Bank implements RBI {
    String accHolder;
    double accBal;
    int accNumber;

    public Bank(String accHolder, int accNumber) {
        this.accHolder = accHolder;
        this.accNumber = accNumber;
        this.accBal = 0.0;
    }

    public Bank(String accHolder, double accBal, int accNumber) {
        this.accHolder = accHolder;
        this.accBal = accBal;
        this.accNumber = accNumber;
    }

    public double getAccBal() {
        return accBal;
    }

    public void setAccBalance(double accBal) {
        this.accBal = accBal;
    }

    public void showBalance() {
        System.out.println("Balance: " + accBal);

    }

    public double withdraw(double amount) {
        if (amount <= accBal)
            accBal -= amount;
        return accBal;
    }

    public double deposit(double amount) {
        accBal += amount;
        return accBal;

    }

    public double calculateYearlyInterest() {
        return (accBal * rateOfInterest);

    }

    @Override
    public String toString() {
        return " [accHolder=" + accHolder + ", accNumber=" + accNumber + "]";
    }

}

class SBIAccount extends Bank {
    static final double accOpeningBonus = 2000;

    public SBIAccount(String accHolder, int accNumber) {
        super(accHolder, accNumber);

    }

    @Override
    public void setAccBalance(double accBal) {

        super.setAccBalance(accBal + accOpeningBonus);
    }

    public void displayFeatures() {
        System.out.println("Additional opening account bonus: " + accOpeningBonus);

    }

}

class ICICIAccount extends Bank {

    static final double additonalInterestRate = 0.02;

    public ICICIAccount(String accHolder, int accNumber) {
        super(accHolder, accNumber);
    }

    @Override
    public double calculateYearlyInterest() {

        return (accBal * (rateOfInterest + additonalInterestRate));

    }

    public void displayFeatures() {
        System.out.println("An additional rate of interest applied of " + additonalInterestRate);

    }

}

public class Interfaces {
    public static void main(String[] args) {
        SBIAccount sbiObj = new SBIAccount("Amruth", 235641);
        ICICIAccount iciciObj = new ICICIAccount("Chowdary", 454684);
        System.out.println("SBI ACCOUNT");
        sbiObj.setAccBalance(6000);
        System.out.println(sbiObj);
        System.out.println("Balance after depositing : " + sbiObj.deposit(800));
        System.out.println("Balance after Withdrawl : " + sbiObj.withdraw(200));
        sbiObj.displayFeatures();

        System.out.println("ICICI ACCOUNT");
        iciciObj.setAccBalance(7000);
        System.out.println(iciciObj);
        System.out.println("Yearly interest=" + sbiObj.calculateYearlyInterest());
        System.out.println("Balance after depositing : " + iciciObj.deposit(800));
        System.out.println("Balance after Withdrwal : " + iciciObj.withdraw(200));
        iciciObj.displayFeatures();

    }
}
