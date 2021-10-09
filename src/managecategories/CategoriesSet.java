package managecategories;

import java.util.HashSet;
import java.util.Set;

public class CategoriesSet {
    private Set<Category> categoriesSet;

    public CategoriesSet(){
        categoriesSet = new HashSet<>();
    }
    public Set<Category> getCategoriesSet(){
        return categoriesSet;
    }

    public void setCategoriesSet(Set<Category> categoriesSet) {
        this.categoriesSet = categoriesSet;
    }

    public void addCategories(Category categories){
        categoriesSet.add(categories);
    }

    public Category getCategories(String name){
        return categoriesSet.stream()
                .filter(categories -> categories.getName().toUpperCase().contains(name.toUpperCase()))
                .findFirst()
                .orElse(new Category("Does not exist"));
    }
    public void removeCategories(Category category){
        categoriesSet.remove(category);
    }

    public boolean existingCategory(String name){
        return categoriesSet.contains(name);
    }

    public void printCategories(){
        categoriesSet.forEach(System.out::println);
    }
}
