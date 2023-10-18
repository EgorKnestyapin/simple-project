package de.ait.app;

import de.ait.repositories.ProductsRepository;
import de.ait.repositories.ProductsRepositoryListImpl;
import de.ait.servivces.ProductsService;
import de.ait.servivces.ProductsServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // конфигурируем приложение - с какими импл будем работать
        ProductsRepository productsRepository = new ProductsRepositoryListImpl();
//        ProductRepository usersTextFileRepository = new UsersRepositoryTextFileImpl("users.txt");
        ProductsService productsService = new ProductsServiceImpl(productsRepository);
        while (true) {
            System.out.println("1. Вывести всё кофе в наличии");
            System.out.println("2. Вывести кофе с самым большим рейтингом");
            System.out.println("3. Вывести самое дешёвое кофе");
            System.out.println("4. Вывести самое дорогое кофе");
            System.out.println("5. Вывести кофе лёгкой обжарки");
            System.out.println("6. Вывести кофе средней прожарки");
            System.out.println("... Вывести кофе ...");
            System.out.println("7. Выход");
            int command = scanner.nextInt(); // считываем команду
            scanner.nextLine(); // чтобы не было бага со сканером
            // вызываем соответствующие "процессы" в нашей программе
            switch (command) {
                case 1:
                    System.out.println("Выводим всё кофе в наличии");
                    System.out.println(productsService.getCoffee());
                    break;
                case 2:
                    System.out.println("Выводим кофе с самым большим рейтингом");
                    System.out.println(productsService.getCoffeeWithHighestRating());
                    break;
                case 3:
                    System.out.println("Выводим самое дешёвое кофе");
                    System.out.println(productsService.getCheapestCoffee());
                    break;
                case 4:
                    System.out.println("...");
                    // здесь напишем код
                    break;
                case 5:
                    System.out.println("...");
                    // здесь напишем код
                    break;
                case 6:
                    System.out.println("...");
                    // здесь напишем код
                    break;
                case 7:
                    System.out.println("Выходим из программы");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Нет такой команды");
            }
        }
    }
}
