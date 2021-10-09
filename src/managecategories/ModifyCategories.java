package managecategories;

import main.PrintConsole;

import java.util.Scanner;

import static java.lang.System.out;

public class ModifyCategories {
    private static CategoriesSet categories;
    PrintConsole printCategories = new PrintConsole();
    Scanner scanner = new Scanner(System.in);


    public void categoriesInput(CategoriesSet categoriesSet){
        categories = categoriesSet;
        boolean menuLoop = true;
        while(menuLoop){
            printCategories.categoryMenu();
            String categoryOption = scanner.nextLine();
            switch (categoryOption) {
                default -> out.println("That was not a valid option, try again! ");
                case "0" -> menuLoop = false;
                case "1" -> addCategory();
                case "2" -> removeCategory();
                case "3" -> printCategories();
            }
        }
    }



    public void searchForACategory(){
        System.out.println("Enter the name of the product you want to search for: ");
        Category category = searchCategory();
        System.out.println("Categories found" + category.getName());
        System.out.println("Do you want to change the category?");
        String option = scanner.nextLine();

        if(option.equals("y")){
            System.out.println("Enter the new name: ");
            String newName = scanner.nextLine();
            category.setName(newName);
            System.out.println("Name updated!");
        }


    }

    private void printCategories() {
        categories.getCategoriesSet().forEach(out::println);
    }

    public Category searchCategory(){
        String search = scanner.nextLine();
        return categories.getCategories(search);
    }


    public void removeCategory(){
        System.out.println("Enter the name of the category you want to remove");
        String s = scanner.nextLine();
        if(s.isEmpty()){
            System.out.println("You need to enter a name");
            return;
        }
        if(!categories.existingCategory(s)){
            System.out.println("The category does not exist!");
            return;
        }
           categories.removeCategories(new Category(s));
        System.out.println("Returning to main menu...");
    }


    public void addCategory(){
        String choice;
        System.out.println("""
      Add a new category by enter
      name of the category below
             ↓ WRITE HERE ↓");""");

        do {
            String s = scanner.nextLine();
            if(s.isEmpty()){
                System.out.println("Enter the name of the category");
                break;
            }
            categories.addCategories(new Category(s));

            System.out.println("You added the category:  " + categories.existingCategory(s));
            System.out.println("Would you like to add another category? [y/n] ");
            choice = scanner.nextLine();

        }while (!choice.equalsIgnoreCase("n"));

        System.out.println("Returning the main menu..");

    }
    


}
