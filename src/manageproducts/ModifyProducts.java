package manageproducts;

import main.PrintConsole;
import managecategories.CategoriesSet;
import managecategories.Category;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.out;

public class ModifyProducts {
    PrintConsole printConsole = new PrintConsole();
    Scanner scanner = new Scanner(System.in);
    CategoriesSet categoriesSet;
    ProductList productList;


    public void productInput(ProductList productList, CategoriesSet categoriesSet) {
        this.categoriesSet = categoriesSet;
        this.productList = productList;

        boolean menuLoop = true;
        while (menuLoop) {
             printConsole.productMenu();
            String productOption = scanner.nextLine();
            switch (productOption) {
                case "1" -> addProduct();
                case "2" -> removeProduct();
                case "3" -> printProducts();
                case "4" -> modifyProduct();
                case "0" -> {
                    out.println("Exiting the product area..");
                    menuLoop = false;
                }
                default -> out.println("You need to enter a valid number!");
            }
        }
    }

    private void printProducts() {
        productList.printProductList();
    }

    private void removeProduct() {
        printProducts();

        out.println("Do you want to remove a product by");
        out.println("1. Name      || 2 EAN-code");
        String input = scanner.nextLine();
        switch (input) {
            case "1":
                out.println("Please enter the EAN code of the product you which to remove");
                int ean = scanner.nextInt();
                if (ean <= 0) {
                    out.println("The EAN-code you have entered is not valid, try again");
                    return;
                }
                try {
                    productList.getProducts().remove(ean);
                } catch (NullPointerException e) {
                    out.println("The product does not exist ");
                }
            case "2":
                out.println("Enter the name of product you which to remove");
                String name = scanner.nextLine();
                if (name.isEmpty()) {
                    out.println("You need to enter a valid name");
                    break;
                }
                try {
                    productList.getProducts().remove(name);
                } catch (NullPointerException e) {
                    out.println("The product does not exist");
                }
        }
    }

    public void addProduct() {
        Product newProduct = new Product();
        boolean productMenu = true;
        while (productMenu) {

            addProductMenu(newProduct);
            String userAddProduct = scanner.nextLine().toLowerCase(Locale.ROOT);
            switch (userAddProduct) {
                case "1":
                    addName(newProduct);
                    break;
                case "2":
                    addSupplier(newProduct);
                    break;
                case "3":
                    addPrice(newProduct);
                    break;
                case "4":
                    addEAN(newProduct);
                    break;
                case "5":
                    addCategory(newProduct);
                    break;
                case "6":
                    addQuantity(newProduct);
                    break;
                case "confirm":
                    try {
                        productList.addProductToList(newProduct);
                        if (condition(newProduct)) {
                            out.println("You have not added all product information!");
                            break;
                        }


                    } catch (Exception e) {
                        out.println("Error");
                    }
                    return;
                case "exit":
                    productMenu = false;
                    break;
                default:
                    out.println("You need to enter a valid number!");
                    break;
            }
        }
    }


    private void modifyProduct() {
        out.println("Enter name of the product you want to modify");
        String name = scanner.nextLine();
        Product productToModify = new Product();
        for (Product product : productList.getProducts()) {
            if (product.getNameOfProduct().equals(name)) {
                return;
            }
        }
        if (!productToModify.getNameOfProduct().equals(name)) {
            return;
        }

        out.println("Enter below what you want to modify ");
        out.println("1. Name    | 4. Quantity");
        out.println("2. Price   | 5. Supplier");
        out.println("3. Category| return");

        String userInput = scanner.nextLine();
        switch (userInput) {

            case "1":
                out.println("Enter new product name");
                String newName = scanner.nextLine();
                productToModify.setNameOfProduct(newName);
                break;

            case "2":
                out.println("Enter new price");
                float newPrice = scanner.nextFloat();
                productToModify.setPrice(newPrice);
                break;
            case "3":
                out.println("Enter category");
                String newCategory = scanner.nextLine();
                productToModify.setCategory(new Category(newCategory));
                break;
            case "4":
                out.println("Enter new quantity");
                int newQuantity = scanner.nextInt();
                productToModify.setQuantity(newQuantity);
                break;
            case "5":
                out.println("Enter new supplier");
                String newSupplier = scanner.nextLine();
                productToModify.setSupplier(newSupplier);
                break;
            case "return":
                break;
        }
    }


    private void addProductMenu(Product newProduct) {
        out.println("[1] add name: {" + newProduct.getNameOfProduct() + "}      | [2] add supplier: {" + newProduct.getSupplier() + "}".trim());
        out.println("[3] add price: {" + newProduct.getPrice() + "}  | [4] EAN-Code: {" + newProduct.getEAN_code() + "}".trim());
        out.println("[5] add Category: {" + newProduct.getCategory() + "}  | [6] add quantity: {" + newProduct.getQuantity() + "}".trim());
        out.println("[confirm]  | Exit");
    }


    //=======================ADDING FIELDS===============================================

    private void addName(Product newProduct) {
        out.println("Enter name of the product ");
        try {
            newProduct.setNameOfProduct(scanner.nextLine());
        } catch (Exception e) {
            out.println("You need to enter a valid name");
        }
    }


    private void addSupplier(Product newProduct) {
        out.println("Enter supplier");
        try {
            newProduct.setSupplier(scanner.nextLine());
        } catch (Exception e) {
            out.println("You need to enter a valid supplier");
        }
    }

    private void addPrice(Product newProduct) {
        out.println("Enter price of the product");
        try {
            newProduct.setPrice(scanner.nextDouble());
        } catch (Exception e) {
            out.println("You need to enter a valid price");
        }
    }

    private void addEAN(Product newProduct) {
        out.println("Enter EAN-code");
        try {
            newProduct.setEAN_code(scanner.nextInt());
        } catch (Exception e) {
            out.println("You need to enter a valie EAN-code");
        }
    }

    private void addCategory(Product newProduct) {
        out.println("Enter category");
        try {
            newProduct.setCategory(new Category(scanner.nextLine()));
        } catch (Exception e) {
            out.println("You need to enter a valid category");
        }

    }

    private void addQuantity(Product newProduct) {
        out.println("Enter quantity");
        try {
            newProduct.setQuantity(scanner.nextInt());
        } catch (Exception e) {
            out.println("You did not enter a valid quantity");
        }
    }


    //===========================SEARCHING==============================

    public void searchForProduct() {


    }

    public void searchProduct() {


    }

    private boolean condition(Product newProduct) {
        if (newProduct.getNameOfProduct().isEmpty())
            out.println("Invalid name");

        if (newProduct.getCategory().getName().isEmpty())
            out.println("Invalid category");
        if (newProduct.getEAN_code() < 0)
            out.println("Invalid EAN-code");

        if (newProduct.getQuantity() < 0)
            out.println("Invalid quantity");

        if (newProduct.getSupplier().isEmpty())
            out.println("Invalid supplier");

        if (newProduct.getPrice() <= 0)
            out.println("Invalid price");
        return true;
    }


}
