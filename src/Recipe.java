import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Recipe {
    private String recipeName;
    private final Set<Product> productSet = new HashSet<>();

    public Recipe(String recipeName, Product... products) {
        setProductName(recipeName);
        productSet.addAll(Arrays.asList(products));
    }

    private void setProductName(String recipeName) {
        if (recipeName != null && !recipeName.isBlank()) {
            this.recipeName = recipeName;
        } else {
            throw new IllegalArgumentException("Наименование рецепта не задано, либо не корректно.");
        }
    }

    public double getProductsPrice() {
        double fullPrice = 0;
        for (Product p : productSet) {
            fullPrice += p.getPrice();
        }
        return fullPrice;
    }

    public String getRecipeName() {
        return recipeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipeName.equals(recipe.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeName);
    }

    @Override
    public String toString() {
        return recipeName + "\n\tнеобходимые продукты: " + productSet + "\n";
    }
}
