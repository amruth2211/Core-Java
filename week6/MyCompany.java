package week6;

interface Client {
    double getCharges();

    double calculatePayment(invoiceDate);

    void sendEmail(double payment);
}

class Customer implements Client {
    int id;
    String name;
    String email;

}

public class MyCompany {
    public static void main(String[] args) {

    }
}
