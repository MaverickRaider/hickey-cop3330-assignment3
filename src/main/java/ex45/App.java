
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Hickey
 */

package ex45;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class WordFinder {
    public static void wordFinder() {
        try {
            // Read in file
            File myObj = new File("exercise45_input.txt");

            // Ask for output file name
            System.out.print("What you would like to call the output file?: ");
            Scanner scan = new Scanner(System.in);
            String outputName = scan.nextLine();
            Scanner myReader = new Scanner(myObj);

            // Turn file into string
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                // Replace 'utilize' with 'use' in the string
                String replaceString = data.replaceAll("utilize", "use");
                // Write output file
                OutputWriter.outputWriter(replaceString, outputName);
            }
            myReader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class OutputWriter {
    public static void outputWriter(String input, String name) {
        try {
            // adds .txt to the end of the file name.
            name = name.concat(".txt");
            FileWriter myWriter = new FileWriter(name);
            myWriter.write(input);
            myWriter.close();
            // Conformation that the system worked
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            // Check the writer for errors
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

public class App {
    public static void main(String args[]) {
        WordFinder.wordFinder();
    }
}
