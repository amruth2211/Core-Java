package project;

import java.util.List;

public class Customer {
    String name;
    Address address;
    Integer customerId;
    List<BankAccount> bankAccounts;

    public Customer(String name, Address address, Integer customerId) {
        this.name = name;
        this.address = address;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer [address=" + address + ", customerId=" + customerId + ", name=" + name + "]";
    }

}
