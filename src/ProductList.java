import exceptions.IllegalProductException;

import java.util.HashSet;
import java.util.Set;

public class ProductList {
    private Set<Product> productSet = new HashSet<>();

    public void addProduct(Product product) {
        if (!productSet.contains(product)) {
            productSet.add(product);
        } else {
            throw new IllegalProductException("Продукт уже был добавлен в список.");
        }
    }

    public void removeProduct(Product product) {
        if (productSet.contains(product)) {
            productSet.remove(product);
        } else {
            throw new IllegalProductException("Продукт не найден.");
        }
    }

    public void buyProduct(Product product) {
        if (productSet.contains(product)) {
            for (Product p : productSet) {
                if (p.equals(product)) {
                    p.setBought(true);
                }
            }
        } else {
            throw new IllegalProductException("Продукт уже был добавлен в список!");
        }
    }

    @Override
    public String toString() {
        String result = String.format("%15s | %5s | %6s | %6s\n", "Наименование", "Цена", "Кол-во", "Куплен");
        for (Product p : productSet) {
            result += String.format("%15s | %.2f | %6s | %6s\n", p.getProductName(), p.getPrice(), p.getCount(),
                    p.isBought() ? "Да" : "Нет");
        }
        return result;
    }
}
