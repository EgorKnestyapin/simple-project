package de.ait.app;

import de.ait.dto.OrderDto;
import de.ait.dto.ProductDto;
import de.ait.repositories.*;
import de.ait.services.OrdersService;
import de.ait.services.OrdersServiceImpl;
import de.ait.services.ProductsService;
import de.ait.services.ProductsServiceImpl;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // конфигурируем приложение - с какими импл будем работать
        ProductsRepository productsRepository = new ProductsRepositoryListImpl();
//        ProductsRepository productsTextFileRepository = new ProductsRepositoryTextFileImpl("products.txt");
        ProductsService productsService = new ProductsServiceImpl(productsRepository);
        OrdersRepository orderRepository = new OrdersRepositoryListImpl();
        OrdersService ordersService = new OrdersServiceImpl(orderRepository, productsService);
        while (true) {
            System.out.println("1. Вывести весь кофе в наличии");
            System.out.println("2. Вывести кофе с самым высоким рейтингом");
            System.out.println("3. Вывести самое дешёвое кофе");
            System.out.println("4. Вывести самое дорогое кофе");
            System.out.println("5. Вывести кофе лёгкой обжарки");
            System.out.println("6. Вывести кофе средней обжарки");
            System.out.println("7. Вывести кофе тёмной обжарки");
            System.out.println("8. Вывести кофе из определенной страны");
            System.out.println("9. Вывести кофе с сортировкой по рейтингу");
            System.out.println("10. Сделать заказ");
            System.out.println("11. Вывести все сделанные заказы");
            System.out.println("12. Добавить кофе");
            System.out.println("13. Изменить степень доступности по id");
            System.out.println("14. Удалить кофе по id");
            System.out.println("15. Выход");
            int command = scanner.nextInt(); // считываем команду
            scanner.nextLine(); // чтобы не было бага со сканером
            // вызываем соответствующие "процессы" в нашей программе
            switch (command) {
                case 1:
                    System.out.println("Выводим весь кофе в наличии");
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
                    System.out.println("Введите название страны:");
                    String country = scanner.next();
                    System.out.println(productsService.getCoffeeFromCountry(country));
                    break;
                case 9:
                    System.out.println("Выводим кофе с сортировкой по рейтингу");
                    System.out.println(productsService.getCoffeeSortedByRating());
                    break;
                case 10:
                    System.out.println("Делаем заказ");
                    System.out.println("Введите id товара:");
                    String id = scanner.nextLine();
                    System.out.println("Введите количество:");
                    String count = scanner.nextLine();
                    System.out.println("Введите email для отправки чека:");
                    String email = scanner.nextLine();
                    OrderDto orderDto = new OrderDto(id, count, email);
                    System.out.println(ordersService.makeOrder(orderDto));
                    break;
                case 11:
                    System.out.println("Выводим все сделанные заказы");
                    System.out.println(ordersService.getOrders());
                    break;
                case 12:
                    System.out.println("Добавляем кофе");
                    System.out.println("Введите название страны:");
                    String countryAdd = scanner.nextLine();
                    System.out.println("Введите степень обжарки(LIGHT/MIDDLE/DARK):");
                    String roastDegree = scanner.nextLine();
                    System.out.println("Введите сорт кофе(ARABICA/ROBUSTA/HYBRID/DECAF):");
                    String coffeeType = scanner.nextLine();
                    System.out.println("Введите цену за 100 гр. кофе:");
                    String pricePer100Gr = scanner.nextLine();
                    System.out.println("Введите рейтинг кофе:");
                    String rating = scanner.nextLine();
                    System.out.println("Введите наличие кофе на складе (true/false):");
                    String isAvailable = scanner.nextLine();
                    System.out.println(productsService.addCoffee(new ProductDto(countryAdd, roastDegree, coffeeType,
                            pricePer100Gr, rating, isAvailable)));
                    break;
                case 13:
                    System.out.println("Изменяем степень доступности по id");
                    String idStatus = scanner.nextLine();
                    System.out.println(productsService.updateProductStatus(idStatus));
                    break;
                case 14:
                    System.out.println("Удаляем кофе по id");
                    System.out.println("Введите id:");
                    String idDelete = scanner.nextLine();
                    System.out.println(productsService.removeCoffeeById(idDelete));
                    break;
                case 15:
                    System.out.println("Выход из программы");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Нет такой команды");
            }
        }
    }
}
