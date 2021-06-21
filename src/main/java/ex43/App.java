
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Hickey
 */

package ex43;

import java.io.*;
import java.util.Scanner;

class WebsiteMaker {
    public static void websiteMaker() {
        Scanner scan = new Scanner(System.in);

        // Asks user for site details
        System.out.print("Site name: ");
        String siteName;
        siteName = scan.nextLine();
        System.out.print("Author: ");
        String author;
        author = scan.nextLine();

        // Asks user if they want to add a folder for JS or CSS
        System.out.print("Do you want a folder for JavaScript? (Y or N) ");
        String js = scan.nextLine();
        js = js.toLowerCase(); // Ensures case-insensitivity
        System.out.print("Do you want a folder for CSS? (Y or N) ");
        String css = scan.nextLine();
        css = css.toLowerCase(); // Ensures case-insensitivity

        // Create website
        String path = System.getProperty("user.dir");
        path += "\\" + siteName;
        File website = new File(path);
        boolean websiteCreated = website.mkdir();

        // Check to make sure site was actually created.
        if (websiteCreated) {
            System.out.println("Created " + path);

            // Write the site up
            try {
                // HTML creation
                FileWriter writer = new FileWriter(new File(path + "\\index.html"));
                writer.write("<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
                writer.write("\t<meta author=\"" + author + "\">\n");
                writer.write("\t<title>" + siteName + "</title>\n");
                writer.write("</head>\n<body>\n\n</body>\n</html>");
                writer.close();
                System.out.println("Created " + path + "\\index.html");

                // Was Javascript added?
                if (js.equals("y")) {

                    File jsFolder = new File(path + "\\js");
                    System.out.println("Created " + jsFolder+"\\");
                }

                // Was CSS added?
                if (css.equals("y")) {

                    File cssFolder = new File(path + "\\css");
                    System.out.println("Created " + cssFolder+"\\");

                }
            }
            // Making sure the writer worked
            catch(IOException e) {
                System.out.println("Error with Writer.");
                e.printStackTrace();
            }
        }
        else {
            // Making sure the website didn't fail
            System.out.println("Website not Made!");
        }
        scan.close();
    }
}

public class App {
    public static void main(String[] args) {

        WebsiteMaker.websiteMaker();
    }
}
