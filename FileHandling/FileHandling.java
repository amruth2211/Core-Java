package FileHandling;

import java.io.File;
import java.io.FileWriter;
// Importing the IOException class for handling errors  
import java.io.IOException;

class FileHandling {
    public static void main(String[] args) {
        try {
            // Creating an object of a file
            File f0 = new File("FileHandling/FileOperationExample.txt");
            if (f0.createNewFile()) {
                System.out.println("File " + f0.getName() + " is created successfully.");
            }
            if (f0.exists()) {
                // Getting file name
                System.out.println("The name of the file is: " + f0.getName());

                // Getting path of the file
                System.out.println("The absolute path of the file is: " + f0.getAbsolutePath());

                // Checking whether the file is writable or not
                System.out.println("Is file writeable?: " + f0.canWrite());

                // Checking whether the file is readable or not
                System.out.println("Is file readable " + f0.canRead());
            } else {
                System.out.println("File is already exist in the directory.");
            }

            FileWriter fwrite = new FileWriter("FileHandling/FileOperationExample.txt");
            // writing the content into the FileOperationExample.txt file
            fwrite.write("A named location used to store related information is referred to as a File.");

            // Closing the stream
            fwrite.close();
            System.out.println("Content is successfully wrote to the file.");

        } catch (IOException exception) {
            System.out.println("An unexpected error is occurred.");
            exception.printStackTrace();
        }
    }
}