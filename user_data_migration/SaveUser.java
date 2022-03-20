package user_data_migration;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveUser {
    public static void main(String[] args) {
        try (FileOutputStream fs = new FileOutputStream("user_data_migration/userdata.txt")) {
            ObjectOutputStream out = new ObjectOutputStream(fs);
            // Creating the object
            User u = new User("Amruth", "Chowdarya@gmail.com", "absc123");
            // Write the object into the file
            out.writeObject(u);
            // Flush the output stream pipe
            out.flush();
            System.out.println("user record saved");
        } catch (Exception e) {
            System.out.println("failure");
            System.out.println(e);
        }
    }
}
