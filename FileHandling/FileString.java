package FileHandling;

import java.io.*;
import java.util.Scanner;

public class FileString {
    public static void main(String[] args) throws IOException {
        try (FileWriter w = new FileWriter("FileHandling/Fileout.txt"); // try with resources
                Scanner scr = new Scanner(new File("FileHandling/FileDemo.txt"));) {
            String s = "";

            // Scanner scr = new Scanner(new File("week5/FileDemo.txt"));
            while (scr.hasNextLine()) {
                s += scr.nextLine(); // can use Stringbuilder and index method
            }

            // BufferedReader br = new BufferedReader(new FileReader("week5/FileDemo.txt"));
            // while((s=br.readLine())!=null) {
            // s+=s;
            // }

            char c = '@';
            String ap = "123";
            String out = s.substring(0, 5) + c + s.substring(5);
            out += ap;
            // FileWriter w = new FileWriter("week5/Fileout.txt");
            w.write(out);

            System.out.println("Content is successfully wrote to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
