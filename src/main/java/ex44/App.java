
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Michael Hickey
 */


package ex44;

import java.io.*;
import java.util.*;

import com.google.gson.*;

// Makes Product Object for list
class Product {
    public String name;
    public double price;
    public int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

class ProductSearch {
    public static void productSearch() {
        // Was used to display the list as to ensure JSON file was being read
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // Read JSON file
        File input = new File("exercise44_input.json");

        try {
            // Parse data
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = fileElement.getAsJsonObject();

            // Place data into list
            JsonArray jsonArrayProducts = fileObject.get("products").getAsJsonArray();
            List<Product> products = new ArrayList<>();

            for (JsonElement productElement : jsonArrayProducts) {
                JsonObject productJsonObject = productElement.getAsJsonObject();

                String name = productJsonObject.get("name").getAsString();
                Double price = productJsonObject.get("price").getAsDouble();
                Integer quantity = productJsonObject.get("quantity").getAsInt();

                Product product = new Product(name, price, quantity);
                products.add(product);
            }

            // Ask user for product to search
            while (true) {
                System.out.print("What is the product name? ");
                Scanner scan = new Scanner(System.in);
                String search = scan.nextLine();
                // Make search term formatted to ignore case issues
                String formattingInput = search.toLowerCase();
                String moddedSearch = formattingInput.substring(0, 1).toUpperCase() + formattingInput.substring(1);

                // Search list for matching product
                int counter = 0; // counter used to target the object in list
                for(Product name : products){
                    // If product found, list values
                    if(name.getName() != null && name.getName().contains(moddedSearch)) {
                        Product target = products.get(counter);
                        System.out.println("Name: " + target.getName());
                        System.out.printf("Price: $%.2f\n",target.getPrice());
                        System.out.println("Quantity: " + target.getQuantity());
                        System.exit(0);
                    }
                    counter++;
                }
                // Loop back if product is not found
                System.out.println("Sorry, that product was not found in our inventory.");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class App {
    public static void main(String[] args) {
        ProductSearch.productSearch();
    }
}
