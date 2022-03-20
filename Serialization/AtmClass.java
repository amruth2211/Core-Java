package Serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class AtmClass {
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = null;
        FileInputStream fin = null;
        try {
            // Reading the object file
            fin = new FileInputStream("Serialization/c.txt");
            // Creating stream to read the object
            in = new ObjectInputStream(fin);
            BankAccount b2 = (BankAccount) in.readObject();
            // printing the data of the serialized object
            System.out.println(b2.getAccbalance());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // closing the stream
            in.close();
            // closing the file input stream
            fin.close();
        }
    }

}
