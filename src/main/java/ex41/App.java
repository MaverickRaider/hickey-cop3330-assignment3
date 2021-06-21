
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Hickey
 */

package ex41;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class NameSorter {
    public static void nameSorter() {
        try {
            // Read input file
            File file = new File("exercise41_input.txt");
            Scanner scan = new Scanner(file);

            // Place into Array of Strings
            ArrayList<String> names = new ArrayList<>();
            while (scan.hasNextLine()) {
                names.add(scan.nextLine());
            }
            scan.close();

            // Sort Strings
            Collections.sort(names, String.CASE_INSENSITIVE_ORDER);

            // Print sorted List
            for (int i = 0; i < names.size(); i++ ) {
                System.out.println(names.get(i));
            }
        }
        catch (FileNotFoundException e) {
            // If the system cannot find the file, returns error.
            System.out.println("Error! File not Found!");
            e.printStackTrace();
        }
    }
}

public class App {
    public static void main(String[] args) {

        NameSorter.nameSorter();
    }
}

