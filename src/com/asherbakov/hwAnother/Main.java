package com.asherbakov.hwAnother;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
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
        List<Integer> integerList = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            integerList.add(new Random().nextInt(1000));
        }
        System.out.println("Первичная коллекция:");
        System.out.println(integerList);

        // TODO: посмотреть утром, косяк со смещением индексов ;)
//        for (int i = 0; i < integerList.size() - 1; i++) {
//            if (integerList.get(i) % 2 != 0) {
//                integerList.remove(i);
//            }
//        }
        integerList.removeIf(i -> i % 2 != 0);

        System.out.println("Коллекция после удаления нечетных значений:");
        System.out.println(integerList);

        // HW 3 - 2
        // TODO: уточнить, почему не работает с использованием contains
        Set<Task> taskSet = new HashSet<>();
        taskSet.add(new Task());
        while (taskSet.size() < 15) {
            Task task = new Task();
            boolean isCorrect = true;
            for (Task t : taskSet) {
                if (t.equals(task)) {
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect) {
                taskSet.add(task);
            }
        }
        for (Task t : taskSet) {
            System.out.println(t);
        }

        // HW 3 - 3
//        Set<Passport> passportSet = new HashSet<>();
        PassportList passportList = new PassportList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean allMore = true;
        while(allMore) {
            System.out.println("Введите серию и номер паспорта (ХХ ХХ ХХХХХХ):");
            String passportNumber = reader.readLine();
            System.out.println("Введите фамилию:");
            String passportLastName = reader.readLine();
            System.out.println("Введите имя:");
            String passportfirstName = reader.readLine();
            System.out.println("Введите отчество (если есть):");
            String passportMiddleName = reader.readLine();
            System.out.println("Введите дату рождения (XX-XX-XXXX):");
            String passportDateOfBirthday = reader.readLine();
            String[] dateOfBirthday = null;
            if (!passportDateOfBirthday.isBlank()) {
                dateOfBirthday = passportDateOfBirthday.split("-");
            } else {
                throw new IllegalArgumentException("Дата рождения не указана, либо указана не верно.");
            }
            Passport passport = new Passport(
                    passportNumber,
                    passportLastName,
                    passportfirstName,
                    passportMiddleName,
                    LocalDate.of(Integer.parseInt(dateOfBirthday[2]), Integer.parseInt(dateOfBirthday[1]), Integer.parseInt(dateOfBirthday[0]))
            );
            passportList.addPassport(passport);
            System.out.println("Добавить ещё один пасспорт? (для выхода нажмите 'n')");
            String answer = reader.readLine();
            if (answer.equalsIgnoreCase("n")) {
                allMore = false;
            }
        }

        System.out.println("Получить информацию по номеру паспорта (ХХ ХХ ХХХХХХ):");
        String passportNumber = reader.readLine();
        System.out.println(passportList.getPassport(passportNumber));

    }
}