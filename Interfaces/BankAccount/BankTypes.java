package Interfaces.BankAccount;

class PhoneNumber {
    String countryCode;
    String phNo;

    PhoneNumber(String countryCode, String phNo) {
        this.countryCode = countryCode;
        this.phNo = phNo;
    }

    @Override
    public String toString() {
        return countryCode + "-" + phNo;
    }
}

class IndianPhoneNumber extends PhoneNumber {
    IndianPhoneNumber(String phNo) {
        super("+91", phNo);
    }
}

interface WorldBank {
    int RATE_OF_INTEREST = 10;

    void showBalance();

    double withdraw(double amount);

    double deposit(double amount);
}

interface RBI extends WorldBank {
    int RATE_OF_INTEREST = 4;

    double calculateYearlyInterest();

    default void upiPaymentFeature() {
        System.out.println("UPI Payment enabled");
    }

    static PhoneNumber getPhNoInstance(String phNo) {
        return new IndianPhoneNumber(phNo);
    }

    static void regulatedBy() {
        System.out.println("Regulated by: Reserve Bank of India. Under the jurisdiction of " + getCountryAuthority());
    }

    private static String getCountryAuthority() {
        return "Govt. of India";
    }
}

class GeneralSavingsAccount implements RBI {
    String accHolder;
    double accBalance;
    int accNumber;
    String bankName;
    PhoneNumber phoneNumber;

    public GeneralSavingsAccount(String accHolder, int accNumber, String bankName, PhoneNumber phoneNumber) {
        this.accHolder = accHolder;
        this.accBalance = 0.0;
        this.accNumber = accNumber;
        this.bankName = bankName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void showBalance() {
        System.out.println("Balance : " + this.accBalance);
    }

    @Override
    public double withdraw(double amount) {
        if (this.accBalance < amount)
            System.out.println("Insufficient Balance : " + this.accBalance);
        else {
            System.out.println("Amount Withdrawed : " + amount);
            this.accBalance -= amount;
        }
        return this.accBalance;
    }

    @Override
    public double deposit(double amount) {
        System.out.println("Amount Deposited : " + amount);
        this.accBalance += amount;
        return this.accBalance;
    }

    @Override
    public double calculateYearlyInterest() {
        return (accBalance * RATE_OF_INTEREST) / 100;
    }

    void displayFeatures() {
        System.out.println("Features OF " + this.getClass().getSimpleName() + " : ");
    }

    @Override
    public String toString() {
        return "GeneralSavingsAccount [accBalance=" + accBalance + ", accHolder=" + accHolder + ", accNumber="
                + accNumber + ", bankName=" + bankName + ", phoneNumber=" + phoneNumber + "]";
    }
}

class SBIAccount extends GeneralSavingsAccount {
    static int count = 1;
    static int accOpeningBonus = 100;

    public SBIAccount(String accHolder, PhoneNumber phoneNumber) {
        super(accHolder, count++, "SBI", phoneNumber);
        this.accBalance += accOpeningBonus;

    }

    @Override
    void displayFeatures() {
        super.displayFeatures();
        System.out.println("Provides " + accOpeningBonus + " as Opening Bonus");
    }
}

class ICICIAccount extends GeneralSavingsAccount {
    static int count = 1;
    int additionalInterest = 2;

    public ICICIAccount(String accHolder, PhoneNumber phoneNumber) {
        super(accHolder, count++, "ICICI", phoneNumber);
    }

    @Override
    public void upiPaymentFeature() {
        System.out.println("UPI Payment disabled");
    }

    @Override
    void displayFeatures() {
        super.displayFeatures();
        System.out.println("Provides additional interest of " + additionalInterest + "%");
    }

    @Override
    public double calculateYearlyInterest() {
        return (accBalance * (RATE_OF_INTEREST + additionalInterest)) / 100;
    }
}

public class BankTypes {
    public static void main(String[] args) {
        SBIAccount sbiAccount = new SBIAccount("Deepika", RBI.getPhNoInstance("63637783333"));
        System.out.println(sbiAccount);
        System.out.println("Balance after withdrawing :" + sbiAccount.withdraw(20));
        System.out.println("Balance after depositing : " + sbiAccount.deposit(1500));
        System.out.println("Yearly Interest : " + sbiAccount.calculateYearlyInterest());
        sbiAccount.displayFeatures();
        sbiAccount.upiPaymentFeature();
        System.out.println();

        ICICIAccount iciciAccount = new ICICIAccount("Jhansi", RBI.getPhNoInstance("732838393627"));
        System.out.println(iciciAccount);
        System.out.println("Balance after depositing : " + iciciAccount.deposit(2000));
        System.out.println("Balance after withdrawing :" + iciciAccount.withdraw(50));
        System.out.println("Yearly Interest : " + iciciAccount.calculateYearlyInterest());
        iciciAccount.displayFeatures();
        iciciAccount.upiPaymentFeature();

        RBI.regulatedBy();
    }
}
