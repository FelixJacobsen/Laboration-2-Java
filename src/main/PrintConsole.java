package main;

import static java.lang.System.out;

public class PrintConsole {
    public void firstMenu(){
        out.println("Welcome ");
        out.println("Enter your choice of following options bellow");
        out.println("0. Exit the program");
        out.println("1. Information and commands for products  ");
        out.println("2. Information and commands for categories");
        out.println("3. Search for a product");
        out.println("4. Modify a product");
        out.println("5. Add product to cart");

    }

    public void productMenu(){
        out.println("=================================");
        out.println("0. Exit product menu");
        out.println("1. Add a new product");
        out.println("2. Remove a current product");
        out.println("3. Print all current products");

    }

    public void categoryMenu(){
        out.println("=================================");
        out.println("0. Exit category menu");
        out.println("1. Add a new category");
        out.println("2. Remove a existing category");
        out.println("3. Print all categories");
    }

    public void searchMenu(){
        out.println("================================");
        out.println("0. Exit search menu");
        out.println("1. Search product by EAN-code: ");
        out.println("2. Search product by name: ");
        out.println("3. Search product by price: ");
    }


}
