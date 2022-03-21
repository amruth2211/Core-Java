package Interfaces.BankAccount;

class GeneralAccount {
    int accNo;
    String accHolderName;
    double accBalance;

    GeneralAccount() {
        accNo = 0;
        accHolderName = "";
        accBalance = 0.0;
    }

    GeneralAccount(int accNo, String accHolderName, double accBalance) {
        this.accNo = accNo;
        this.accHolderName = accHolderName;
        this.accBalance = accBalance;
    }

    public GeneralAccount(int accNo, String accHolderName) {
        this.accNo = accNo;
        this.accHolderName = accHolderName;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accountHolder) {
        accHolderName = accountHolder;
    }

    public double getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }

    public String toString() {
        return "accNo is: " + accNo + "\nacc holder name is: " + accHolderName + " \naccount balance is: " + accBalance;
    }

    public GeneralAccount getStatement() { // RETURN TYPE IS OBJECT CLASS ,COVARIENT RETURN TYPE
        System.out.println(this.getClass().getSimpleName());
        return this;
    }

    GeneralAccount copy(GeneralAccount generalacc) {
        return new GeneralAccount(accNo, accHolderName);
    }
}

class SavingsAccount extends GeneralAccount {
    static double rateOfInterest = 10;

    SavingsAccount(int accNo, String accHolderName) {
        super(accNo, accHolderName);
    }

    public double getYearlyInterest() {
        return ((getAccBalance() * getRateOfInterest()) / 100);

    }

    double getRateOfInterest() {
        return rateOfInterest;
    }

    public double getComputedInterest(int years) {
        double res = getYearlyInterest();
        return res * years;
    }

    @Override
    public SavingsAccount getStatement() { // COVARIENT RETURN TYPE
        System.out.println(this.getClass().getSimpleName()); // THIS RETURNS THE CURRENT OBJECT name
        return this;
    }

    SavingsAccount copy(SavingsAccount a) {
        return new SavingsAccount(accNo, accHolderName);
    }
}

class CurrentAccount extends GeneralAccount {
    double avgDailyTransaction;

    CurrentAccount() {
        super();
        this.avgDailyTransaction = 0.0;
    }

    CurrentAccount(int accNo, String accHolderName) {
        super(accNo, accHolderName);
    }

    public void setAvgDailyTransaction(double t) {
        avgDailyTransaction = t;
    }

    public double getAvgDailyTransaction() {
        return avgDailyTransaction;

    }

    public double getTotalTransactionAmount(int days) {
        return avgDailyTransaction * days;
    }

    public double getYearlyTransaction() {
        return getTotalTransactionAmount(365);
    }

    @Override
    public String toString() {

        return super.toString() + "\naverage daily transaction is: " + avgDailyTransaction;

    }
}

class BankAccounts {
    public static void main(String[] args) {
        GeneralAccount generalacc = new GeneralAccount(5421, "Amruth", 5000000);
        CurrentAccount currentAcc = new CurrentAccount(2254145, "Amruth");
        SavingsAccount savingsAcc = new SavingsAccount(2145, "Amruth");
        generalacc.setAccBalance(1000);
        System.out.println(generalacc);

        savingsAcc.setAccBalance(2000);
        System.out.println(savingsAcc);
        System.out.println("Yearly interest credited = " +
                savingsAcc.getYearlyInterest());
        System.out.println("Interest calculated = " +
                savingsAcc.getComputedInterest(2));

        currentAcc.setAvgDailyTransaction(1000);
        System.out.println(currentAcc);
        System.out.println("Yearly Transaction :" +
                currentAcc.getYearlyTransaction());
        System.out.println("Total Transaction :" +
                currentAcc.getTotalTransactionAmount(2));

        System.out.println(savingsAcc.getStatement());
        System.out.println(generalacc.copy(generalacc));
        System.out.println(savingsAcc.copy(savingsAcc));
    }
}
