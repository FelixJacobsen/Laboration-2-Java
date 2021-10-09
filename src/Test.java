/*
import manageproducts.Product;

import java.util.Locale;

import static java.lang.System.out;

public class Test {

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
*/
