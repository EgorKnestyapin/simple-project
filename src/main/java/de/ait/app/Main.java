package de.ait.app;

import de.ait.repositories.ProductsRepository;
import de.ait.repositories.ProductsRepositoryListImpl;
import de.ait.repositories.ProductsRepositoryTextFileImpl;
import de.ait.servivces.ProductsService;
import de.ait.servivces.ProductsServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // конфигурируем приложение - с какими импл будем работать
//        ProductsRepository productsRepository = new ProductsRepositoryListImpl();
        ProductsRepository productsTextFileRepository = new ProductsRepositoryTextFileImpl("products.txt");
        ProductsService productsService = new ProductsServiceImpl(productsTextFileRepository);
        while (true) {
            System.out.println("1. Вывести всё кофе в наличии");
            System.out.println("2. Вывести кофе с самым высоким рейтингом");
            System.out.println("3. Вывести самое дешёвое кофе");
            System.out.println("4. Вывести самое дорогое кофе");
            System.out.println("5. Вывести кофе лёгкой обжарки");
            System.out.println("6. Вывести кофе средней прожарки");
            System.out.println("7. Вывести кофе тёмной прожарки");
            System.out.println("8. Вывести кофе из определенной страны");
            System.out.println("9. Вывести кофе с сортировкой по рейтингу");
            System.out.println("10. Добавить кофе");
            System.out.println("11. Удалить кофе по id");
            System.out.println("12. Изменить степень доступности по id");
            System.out.println("13. Выход");
            int command = scanner.nextInt(); // считываем команду
            scanner.nextLine(); // чтобы не было бага со сканером
            // вызываем соответствующие "процессы" в нашей программе
            switch (command) {
                case 1:
                    System.out.println("Выводим всё кофе в наличии");
                    System.out.println(productsService.getCoffee());
                    break;
                case 2:
                    System.out.println("Выводим кофе с самым высоким рейтингом");
                    System.out.println(productsService.getCoffeeWithHighestRating());
                    break;
                case 3:
                    System.out.println("Выводим самое дешёвое кофе");
                    System.out.println(productsService.getCheapestCoffee());
                    break;
                case 4:
                    System.out.println("Выводим самое дорогое кофе");
                    System.out.println(productsService.getMostExpensiveCoffee());
                    break;
                case 5:
                    System.out.println("Выводим кофе лёгкой обжарки");
                    System.out.println(productsService.getCoffeeLightRoastDegree());
                    break;
                case 6:
                    System.out.println("Выводим кофе средней обжарки");
                    System.out.println(productsService.getCoffeeMiddleRoastDegree());
                    break;
                case 7:
                    System.out.println("Выводим кофе тёмной обжарки");
                    System.out.println(productsService.getCoffeeDarkRoastDegree());
                    break;
                case 8:
                    System.out.println("Выводим кофе из определенной страны");
                    System.out.println(productsService.getCoffeeFromCountry());
                    break;
                case 9:
                    System.out.println("Выводим кофе с сортировкой по рейтингу");
                    System.out.println(productsService.getCoffeeSortedByRating());
                    break;
                case 10:
                    System.out.println("Добавляем кофе");
                    // код
                    break;
                case 11:
                    System.out.println("Изменяем степень доступности по id");
                    // код
                    break;
                case 12:
                    System.out.println("Удаляем кофе по id");
                    // код
                    break;
                case 13:
                    System.out.println("Выход из программы");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Нет такой команды");
            }
        }
    }
}
