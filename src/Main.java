import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // HW 1 - 1
        ProductList newYearProductList = new ProductList();
        newYearProductList.addProduct(new Product("Мандарины", 86.90, 2));
//        newYearProductList.addProduct(new Product("Fish", 256, 1));
        // Идентичными считаю продукты с одинаковым наименованием и ценой
        newYearProductList.addProduct(new Product("Мандарины", 86.91, 2.4));
        newYearProductList.addProduct(new Product("Картофель", 48.20, 4));
        System.out.println("Список продуктов после заполнения:");
        System.out.println(newYearProductList);

        newYearProductList.removeProduct(new Product("Мандарины", 86.91, 2.4));
        newYearProductList.buyProduct(new Product("Мандарины", 86.90, 2));
        System.out.println("Список продуктов после внесения изменений:");
        System.out.println(newYearProductList);

        // HW 2 - 1
        Recipe recipe1 = new Recipe("Оливье",
                new Product("Картофель", 48.20, 4),
                new Product("Морковь", 48.20, 4),
                new Product("Огурцы", 48.20, 4),
                new Product("Яйца", 48.20, 4));

        Recipe recipe2 = new Recipe("Оливье (бюджетный)",
                new Product("Картофель", 48.20, 4),
                new Product("Морковь", 48.20, 4),
                new Product("Огурцы", 48.20, 4),
                new Product("Яйца", 48.20, 4));

        Recipe recipe3 = new Recipe("Вареный картофель",
                new Product("Картофель", 48.20, 4));
        RecipeBook recipeBook = new RecipeBook();
        recipeBook.addRecipe(recipe1);
        recipeBook.addRecipe(recipe2);
        recipeBook.addRecipe(recipe3);
        System.out.println("Книга рецептов:");
        System.out.println(recipeBook);

        // HW 2 - 2
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            integerList.add(new Random().nextInt(1000));
        }
        System.out.println("Первичная коллекция:");
        System.out.println(integerList);

        // TODO: посмотреть утром ;)
        for (int i = 0; i < integerList.size() - 1; i++) {
            if (integerList.get(i) % 2 != 0) {
                integerList.remove(i);
            }
        }
        System.out.println("Коллекция после удаления нечетных значений:");
        System.out.println(integerList);
    }
}