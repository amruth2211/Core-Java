package user_data_migration;

import java.lang.Class;
import java.lang.reflect.*;
import java.io.*;

public class Fetch {
    public static void main(String args[]) throws IOException {
        ObjectInputStream in = null;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("user_data_migration/userdata.txt");
            in = new ObjectInputStream(fin);
            User s = (User) in.readObject();

            System.out.println("user record retrieved");

            Class usercls = s.getClass();
            Field pass = usercls.getDeclaredField("password");
            pass.setAccessible(true);
            pass.set(s, "1234");

            System.out.println(s);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            in.close();
            fin.close();
        }
    }
}
