
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Hickey
 */

package ex42;

import java.io.*;

class TableMaker {
    public static void tableMaker() {
        // Top of data table
        // Formats the top of the table to align well with the data below.
        System.out.printf( "%-10s %-10s %-10s\n", "Last", "First", "Salary");
        System.out.println("-----------------------------");
    }
}

class ParsingDataFile {
    public static void parsingDataFile() throws IOException {
        // Reads in the file
        BufferedReader br = new BufferedReader(new FileReader("exercise42_input.txt"));
        String line;

        // Count is to help format the table of data, knowing how the input file is written we can prep the while loop.
        int count = 0;

        // Reads each line, skipping the ","
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            for (String str : values) {
                if (count == 3){
                    System.out.println();
                    count = 0;
                }
                count++;
                // Prints each string
                System.out.printf( "%-11s", str);
            }
        }
        br.close();
    }
}

public class App {

    public static void main(String[] args) throws Exception {
        TableMaker.tableMaker();
        ParsingDataFile.parsingDataFile();
    }
}
