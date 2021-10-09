package manageproducts;

import java.util.*;
import java.util.stream.Collectors;

public class ProductList {
    private static List<Product> listWithProducts;

    public  ProductList(){
        listWithProducts = new ArrayList<>();
    }

    public List<Product> getProducts(){
        return Collections.unmodifiableList(listWithProducts);
    }

    public void setProducts(List<Product> products) {
        for(Product p : products)
            addProductToList(p);
    }

    public void addProductToList(Product product){
        listWithProducts.add(product);
    }

    public void removeProductFromList(Product product){
        listWithProducts.remove(product);
    }

    public Product getProductEan(int ean)
    {
        return  listWithProducts.stream()
                .filter(p -> p.getEAN_code() == ean)
                .findFirst()
                .orElse(new Product());
    }

    public Product getProductName(String name) {
       return listWithProducts.stream()
               .filter(p -> p.getNameOfProduct().equals(name))
               .findFirst()
               .orElse(new Product());
    }


    public void printProductList(){
        listWithProducts.forEach(System.out::println);
    }

    //=================Sorting=====================
    //=============================================

    public List<Product> sortProductsByName(String name) {
        return listWithProducts.stream()
                .filter(product -> product.getNameOfProduct().equals(name))
                .collect(Collectors.toList());
    }

    public List<Product> sortProductsByPrice(float minPrice, float maxPrice) {
        return listWithProducts.stream().filter(product -> product.getPrice()
                        <= maxPrice && product.getPrice() >= minPrice)
                .collect(Collectors.toList());
    }

    public List<Product> sortProductsByCategories() {
        return  listWithProducts.stream()
                .sorted(Comparator.comparing(Product::getNameOfProduct))
                .toList();
    }








}
