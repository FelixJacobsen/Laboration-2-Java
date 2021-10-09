package csv;

import managecategories.CategoriesSet;
import managecategories.Category;
import manageproducts.Product;
import manageproducts.ProductList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {
    private static final Pattern pattern = Pattern.compile(",");
    private static final ProductList products = new ProductList();
    private static final CategoriesSet categorySet = new CategoriesSet();
    static public String HOME_PATH = System.getProperty("user.dir");


    public static ProductList readProduct() {
        Path productPath = Path.of(HOME_PATH, "resources", "Product.csv");
        List<Product> p = List.of();

        try (Stream<String> lines = Files.lines(productPath)) {
            p = lines
            .map(Reader::createProduct)
            .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        products.setProducts(p);
        return products;
    }

    public static Product createProduct(String s) {
        String[] arr = pattern.split(s);

        return new Product(arr[0], arr[1], Double.parseDouble(arr[2]), Integer.parseInt(arr[3]), categorySet.getCategories(arr[4]), Integer.parseInt(arr[5]));

    }


    public static CategoriesSet readCategories() {
        Path categoryPath = Path.of(HOME_PATH, "resources", "Categories.csv");
        Set<Category> categories = Set.of();

        try (Stream<String> lines = Files.lines(categoryPath)) {
            categories = lines
                    .map(Reader::createCategories)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        categorySet.setCategoriesSet(categories);
        return categorySet;
    }

    private static Category createCategories(String s) {
        return new Category(s);
    }

}
