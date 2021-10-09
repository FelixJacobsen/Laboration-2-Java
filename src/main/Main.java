package main;

import csv.Reader;
import csv.Writer;
import managecategories.CategoriesSet;
import managecategories.ModifyCategories;
import manageproducts.ModifyProducts;

import manageproducts.ProductList;
import test.Cart;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        Run run  = new Run();
        run.runMain();
    }
}

class Run {
    Scanner scanner = new Scanner(System.in);
    PrintConsole printer = new PrintConsole();
    ModifyProducts modifyProducts = new ModifyProducts();
    ModifyCategories modifyCategories = new ModifyCategories();
    ProductList productList = Reader.readProduct();
    CategoriesSet categoriesSet = Reader.readCategories();
    Cart cart = new Cart();


    public void runMain() {
        boolean firstMenu = true;
        while (firstMenu) {
            printer.firstMenu();
            String firstOption = scanner.nextLine();
            switch (firstOption) {
                default -> out.println("The option does not exist, try again! ");
                case "1" -> modifyProducts.productInput(productList, categoriesSet);
                case "2" -> modifyCategories.categoriesInput(categoriesSet);
                case "5" -> cart.run();

                case "0" -> {
                    out.println("Exiting program. All data will be saved to file. ");
                    firstMenu = false;
                    Writer.saveCategory(categoriesSet);
                    Writer.saveProducts(productList);
                }


            }
        }
    }
}