package Serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Kiosk {
    public static void main(String[] args) {
        try (FileOutputStream fout = new FileOutputStream("Serialization/c.txt");
                ObjectOutputStream out = new ObjectOutputStream(fout);) {
            // Creating the object
            BankAccount b = new BankAccount(52, "aas", 5);
            // Write the object into the file
            out.writeObject(b);
            // Flush the output stream pipe
            out.flush();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("failure");
            System.out.println(e);
        }
    }
}
