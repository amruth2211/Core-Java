package FileHandling;

// ****************************************************************************
// Warning.java
//
// Reads student data from a text file and writes data to another text file.
// ****************************************************************************
import java.util.Scanner;

import java.io.*;

public class Warning {
  // --------------------------------------------------------------------
  // Reads student data (name, semester hours, quality points) from a
  // text file, computes the GPA, then writes data to another file
  // if the student is placed on academic warning.
  // --------------------------------------------------------------------
  public static boolean warning(double gpa, int creditHrs) {
    return ((creditHrs < 30 && gpa < 1.5) || (creditHrs < 60 && gpa < 1.75) || (gpa < 2.0));
  }

  public static void main(String[] args) {
    int creditHrs; // number of semester hours earned
    double qualityPts; // number of quality points earned
    double gpa; // grade point (quality point) average
    String line, name, inputName = "students.dat";
    String[] info;
    String outputName = "warning.dat";

    try {
      File file = new File("FileHandling/students.dat");
      Scanner scr = new Scanner(file);
      FileWriter writer = new FileWriter("FileHandling/warning.dat");
      writer.write("Students on Academic Warning\n");
      // Set up scanner to input file
      // Set up the output file stream

      // Print a header to the output file - "Students on Academic Warning"

      // Process the input file, one token at a time
      while (scr.hasNextLine()) {

        line = scr.nextLine();
        info = line.split(" ");
        name = info[0];
        creditHrs = Integer.parseInt(info[1].trim());
        qualityPts = Double.parseDouble(info[2].trim());
        gpa = qualityPts / creditHrs;
        if (warning(gpa, creditHrs))
          writer.write(line + "\n");
      }
      writer.close();
      scr.close();
      System.out.println("File written ");
    }

    catch (FileNotFoundException exception) {
      System.out.println("The file " + inputName + " was not found.");
    } catch (IOException exception) {
      System.out.println(exception.getMessage());
    } catch (NumberFormatException e) {
      System.out.println("Format error in input file: " + e);
    }
  }
}