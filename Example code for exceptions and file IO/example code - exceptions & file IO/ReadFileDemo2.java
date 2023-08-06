import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/** 
 * This is a program that reads two text files, one containing 
 * arbitrary strings, and another containing integers, and prints
 * their contents to the screen.
 */
public class ReadFileDemo2 {
 
  public static void main(String[] args) throws FileNotFoundException {
    
    // Declare strings to hold the file names
    String stringsFileName = "textfiles/demo_file_strings.txt";
    String intsFileName = "textfiles/demo_file_ints.txt";
    
    // Create file objects corresponding to the files we want
    // to read
    File stringsFile = new File(stringsFileName);
    File intsFile = new File(intsFileName);
    
    // read and display the contents of the strings file
    try {
      readAndDisplayStringsFile(stringsFile);
    }
   catch (FileNotFoundException e) {
     System.out.println("Could not read and display: " + stringsFile);
     System.exit(0);
   }
    // read and display the contents of the ints file.
   try {
     readAndDisplayIntsFile(intsFile);
   }
   catch (FileNotFoundException e) {
     System.out.println("Could not read and display: " + intsFile);
     System.exit(0);
   }

    System.out.println();

  }
  
  public static void readAndDisplayStringsFile(File fileToRead) throws FileNotFoundException {
    // Declare a Scanner variable to help read from the 
    // file that we want to read.
    Scanner stringsFileInput = null;
   
    // try to open the file for reading (may throw FileNotFoundException)
    stringsFileInput = new Scanner(fileToRead);
    
    // read the contents of the strings file
    System.out.println("The file has the following contents: ");
    while (stringsFileInput.hasNextLine()){
      String line = stringsFileInput.nextLine();
      System.out.println(line.length() + ": " + line);
    }
    System.out.println();
  }
  
  public static void readAndDisplayIntsFile(File fileToRead) throws FileNotFoundException {
    // Declare a Scanner variable to help read from the 
    // file that we want to read.
    Scanner intsFileInput;
    
    // try to open the file for reading (may throw FileNotFoundException)
    intsFileInput = new Scanner(fileToRead);

    // read the contents of the ints file
    System.out.println("The file has the following contents: ");
    int sum = 0;
    int numberOfNums = 0;
    double average;
    while (intsFileInput.hasNextInt()){
      int num = intsFileInput.nextInt();
      System.out.print(num + ", ");
      numberOfNums++;
      sum += num;
    }
    average = sum / (double) numberOfNums;
    System.out.println("I read " + numberOfNums + " numbers.");
    System.out.println("Their sum is: " + sum);
    System.out.println("Their average is: " + average);
  }    
}