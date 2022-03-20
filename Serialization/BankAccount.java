package Serialization;

import java.io.Serializable;

public class BankAccount implements Serializable {
    int accnum;
    String accholder;
    int accbalance;

    public BankAccount(int accnum, String accholder, int accbalance) {
        this.accnum = accnum;
        this.accholder = accholder;
        this.accbalance = accbalance;
    }

    public int getAccnum() {
        return accnum;
    }

    public void setAccnum(int accnum) {
        this.accnum = accnum;
    }

    public String getAccholder() {
        return accholder;
    }

    public void setAccholder(String accholder) {
        this.accholder = accholder;
    }

    public int getAccbalance() {
        return accbalance;
    }

    public void setAccbalance(int accbalance) {
        this.accbalance = accbalance;
    }

    @Override
    public String toString() {
        return "BankAccount [accbalance=" + accbalance + ", accholder=" + accholder + ", accnum=" + accnum + "]";
    }

}
