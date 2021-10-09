package csv;

import managecategories.CategoriesSet;
import managecategories.Category;
import manageproducts.Product;
import manageproducts.ProductList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Writer {
    static String HOME_PATH = System.getProperty("user.dir");
    static Path csvPath = Path.of(HOME_PATH, "resources", "Product.csv");
    static Pattern pattern = Pattern.compile(",");


    //Spara produkterna i listan
    public static void saveProducts(ProductList products) {

        List<String> strings = new ArrayList<>();
        products.getProducts().forEach(product -> sb(product, strings));

        try {
            Files.write(csvPath, strings, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveCategory(CategoriesSet categories) {
        String HOME_PATH = System.getProperty("user.dir");
        Path categoryPath = Path.of(HOME_PATH, "resources", "Categories.csv");

        List<String> strings = getStrings(categories);
        try {
            Files.write(categoryPath, strings, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static List<String> getStrings(CategoriesSet categoriesSet) {
        return categoriesSet.getCategoriesSet()
                .stream().map(Category::getName)
                .toList();
    }

    //Konvertera till text
    private static void sb(Product product, List<String> strings) {
        StringBuilder stringBuilder = new StringBuilder();
        strings.add(stringBuilder
                .append(product.getNameOfProduct())
                .append(",")
                .append(product.getSupplier())
                .append(",")
                .append(product.getPrice())
                .append(",")
                .append(product.getEAN_code())
                .append(",")
                .append(product.getCategory())
                .append(",")
                .append(product.getQuantity())
                .toString());
    }
}
