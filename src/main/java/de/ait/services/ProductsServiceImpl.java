package de.ait.services;

import de.ait.dto.ProductDto;
import de.ait.models.CoffeeType;
import de.ait.models.Product;
import de.ait.models.RoastDegree;
import de.ait.repositories.ProductsRepository;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class ProductsServiceImpl implements ProductsService {
    ProductsRepository productRepository;

    public ProductsServiceImpl(ProductsRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<String> getCoffee() {
        return productRepository.findAll().stream()
                .filter(Product::isAvailable)
                .map(p -> "\nСтрана: " + p.getCountry() + ", сорт кофе: " + p.getCoffeeType() + ", степень обжарки: "
                        + p.getRoastDegree() + ", цена за 100 гр.: " + p.getPricePer100Gr() + ", рейтинг: "
                        + p.getRating())
                .toList();
    }

    @Override
    public String getCoffeeWithHighestRating() {
        Optional<String> coffeeWithHighestRating = productRepository.findAll().stream()
                .filter(Product::isAvailable)
                .max((a, b) -> Double.compare(a.getRating(), b.getRating()))
                .map(p -> "\nСтрана: " + p.getCountry() + ", сорт кофе: " + p.getCoffeeType() + ", степень обжарки: "
                        + p.getRoastDegree() + ", цена за 100 гр.: " + p.getPricePer100Gr() + ", рейтинг: "
                        + p.getRating());
        return coffeeWithHighestRating.orElse(null);
    }

    @Override
    public String getCheapestCoffee() {
        Optional<String> mostExpensiveCoffee = productRepository.findAll().stream()
                .filter(Product::isAvailable)
                .min((a, b) -> Double.compare(a.getPricePer100Gr(), b.getPricePer100Gr()))
                .map(p -> "\nСтрана: " + p.getCountry() + ", сорт кофе: " + p.getCoffeeType() + ", степень обжарки: "
                        + p.getRoastDegree() + ", цена за 100 гр.: " + p.getPricePer100Gr() + ", рейтинг: "
                        + p.getRating());;
        return mostExpensiveCoffee.orElse(null);
    }

    @Override
    public String getMostExpensiveCoffee() {
        Optional<String> mostExpensiveCoffee = productRepository.findAll().stream()
                .filter(Product::isAvailable)
                .max((a, b) -> Double.compare(a.getPricePer100Gr(), b.getPricePer100Gr()))
                .map(p -> "\nСтрана: " + p.getCountry() + ", сорт кофе: " + p.getCoffeeType() + ", степень обжарки: "
                        + p.getRoastDegree() + ", цена за 100 гр.: " + p.getPricePer100Gr() + ", рейтинг: "
                        + p.getRating());;
        return mostExpensiveCoffee.orElse(null);
    }

    @Override
    public List<String> getCoffeeLightRoastDegree() {
        return productRepository.findAll().stream()
                .filter(product -> product.isAvailable() && product.getRoastDegree() == RoastDegree.LIGHT)
                .map(p -> "\nСтрана: " + p.getCountry() + ", сорт кофе: " + p.getCoffeeType() + ", степень обжарки: "
                        + p.getRoastDegree() + ", цена за 100 гр.: " + p.getPricePer100Gr() + ", рейтинг: "
                        + p.getRating())
                .toList();
    }

    @Override
    public List<String> getCoffeeMiddleRoastDegree() {
        return productRepository.findAll().stream()
                .filter(product -> product.isAvailable() && product.getRoastDegree() == RoastDegree.MIDDLE)
                .map(p -> "\nСтрана: " + p.getCountry() + ", сорт кофе: " + p.getCoffeeType() + ", степень обжарки: "
                        + p.getRoastDegree() + ", цена за 100 гр.: " + p.getPricePer100Gr() + ", рейтинг: "
                        + p.getRating())
                .toList();
    }

    @Override
    public List<String> getCoffeeDarkRoastDegree() {
        return productRepository.findAll().stream()
                .filter(product -> product.isAvailable() && product.getRoastDegree() == RoastDegree.DARK)
                .map(p -> "\nСтрана: " + p.getCountry() + ", сорт кофе: " + p.getCoffeeType() + ", степень обжарки: "
                        + p.getRoastDegree() + ", цена за 100 гр.: " + p.getPricePer100Gr() + ", рейтинг: "
                        + p.getRating())
                .toList();
    }

    @Override
    public List<String> getCoffeeFromCountry(String country) {
        return productRepository.findAll().stream()
                .filter(product -> product.isAvailable() && product.getCountry().equalsIgnoreCase(country))
                .map(p -> "\nСтрана: " + p.getCountry() + ", сорт кофе: " + p.getCoffeeType() + ", степень обжарки: "
                        + p.getRoastDegree() + ", цена за 100 гр.: " + p.getPricePer100Gr() + ", рейтинг: "
                        + p.getRating())
                .toList();
    }

    @Override
    public List<String> getCoffeeSortedByRating() {
        return productRepository.findAll().stream()
                .filter(Product::isAvailable)
                .sorted((a, b) -> Double.compare(b.getRating(), a.getRating()))
                .map(p -> "\nСтрана: " + p.getCountry() + ", сорт кофе: " + p.getCoffeeType() + ", степень обжарки: "
                        + p.getRoastDegree() + ", цена за 100 гр.: " + p.getPricePer100Gr() + ", рейтинг: "
                        + p.getRating())
                .toList();
    }

    @Override
    public String addCoffee(ProductDto productDto) {
        try {
            Product product = new Product(UUID.randomUUID().toString(), productDto.getCountry(),
                    RoastDegree.valueOf(productDto.getRoastDegree()), CoffeeType.valueOf(productDto.getCoffeeType()),
                    Double.parseDouble(productDto.getPricePer100Gr()), Double.parseDouble(productDto.getRating()),
                    Boolean.parseBoolean(productDto.isAvailable()));
            return productRepository.save(product);
        } catch (IllegalArgumentException e) {
            System.out.println("Переданы неверные данные");
        }
        return null;
    }

    @Override
    public Product removeCoffeeById(String id) {
        return productRepository.deleteById(id);
    }
}
