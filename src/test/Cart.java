package test;

import manageproducts.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
    Cart cart;
    Product p = new Product();
    Scanner scanner = new Scanner(System.in);
    LocalDateTime currentDateTime = LocalDateTime.now();
    List<Product> products = new ArrayList<>();

    public void miniMenu() {
        String s = """
                Welcome to the product market!
                Please enter a choice below.
                This is your current options
                        
                1. Go to product area to begin shopping
                2. Delete a current product from your cart
                3. Show all your current products in the cart

                        
                        """;
        System.out.println(s);
    }

    public void run() {
        miniMenu();
        String s = scanner.nextLine();
        switch (s) {
            case "1" -> addProductToCart();
            case "2" -> deleteProductFromCart();
            case "3" -> System.out.println(toString());
        }
    }

    public Product getProductNames(String name) {


        for (Product prod : products)
            if (prod.getNameOfProduct().equals(name))
                return prod;
        return null;
    }


    public void addProduct(Product item, int quantity) {
        for (Product p : products) {
            p.getNameOfProduct().equals(item.getNameOfProduct());
            p.setQuantity(p.getQuantity() + quantity);
            products.add(item);
        }
    }

    public void addProductToCart() {
        System.out.println("Enter name of the product");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Invalid name");
            return;
        }
        if (!name.equals(p.getNameOfProduct())) {
            System.out.println("Product does not exist");
            return;
        }
        System.out.println("Enter the quantity");
        try {
            int quantity = scanner.nextInt();
            if (quantity < p.getQuantity()) {
                System.out.println("There is not that many products ");
                System.out.println("Remaning products: " + p.getQuantity());
                return;
            }
            Product product = new Product(p.getNameOfProduct(), p.getSupplier(), (float) p.getPrice(), p.getEAN_code(), p.getCategory(), quantity);
            cart.addProduct(product,quantity);
            System.out.println("Product added!");
        } catch (Exception e) {
            System.out.println("Something went wrong! ");
        }
    }

    public void deleteProductFromCart() {
        System.out.println("Enter the name of the product");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            System.out.println("Invalid name");
        }
        Product item = cart.getProductNames(name);
        if (item == null) {
            System.out.println("The product is not in your cart");
            return;
        }
        System.out.println("Enter how many products you want to add");
        int quantity = scanner.nextInt();
        try {
            cart.deleteProduct(name, quantity);
            System.out.println(quantity + name + " deleted from cart!");
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    public void deleteProduct(String name, int quanitty) {
        for (Product prod : products){
            if(prod.getNameOfProduct().equals(name))
                prod.setQuantity(p.getQuantity() - quanitty);
        }
    }

    public double totalPrice() {
        double sum = 0;
        for (Product p : products)
            sum = +p.getPrice();
        return sum;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Kvitto" +
                "Datum " + currentDateTime);
        for(Product p : products) {
            stringBuilder.append(p.getNameOfProduct());
            stringBuilder.append("");
            stringBuilder.append(p.getPrice());
            stringBuilder.append("");
        }
        return stringBuilder.toString();
    }
}

