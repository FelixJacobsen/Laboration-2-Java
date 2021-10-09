package manageproducts;

import managecategories.Category;

import java.util.Objects;

public class Product {
    private String nameOfProduct;
    private String supplier;
    private double price;
    private int EAN_code;
    private Category category;
    private int quantity;

    public Product(String nameOfProduct, String supplier, double price, int EAN_code, Category category, int quantity) {
        this.nameOfProduct = nameOfProduct;
        this.supplier = supplier;
        this.price = price;
        this.EAN_code = EAN_code;
        this.category = category;
        this.quantity = quantity;
    }
    public Product(){

    }


    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getEAN_code() {
        return EAN_code;
    }

    public void setEAN_code(int EAN_code) {
        this.EAN_code = EAN_code;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return nameOfProduct.equals(product.nameOfProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfProduct);
    }

    @Override
    public String toString() {
        return "Product{" +
                "nameOfProduct='" + nameOfProduct + '\'' +
                ", supplier='" + supplier + '\'' +
                ", price=" + price +
                ", EAN_code=" + EAN_code +
                ", category=" + category +
                ", quantity=" + quantity +
                '}';
    }
}
