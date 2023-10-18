package de.ait.servivces;

import de.ait.models.Product;
import de.ait.repositories.ProductsRepository;

import java.util.List;

public class ProductsServiceImpl implements ProductsService {
    ProductsRepository productRepository;

    public ProductsServiceImpl(ProductsRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<String> getCoffee() {
        List<String> list = productRepository.findAll().stream()
                .map(product -> "Country: " + product.getCountry() + "\nCoffee type: " + product.getCoffeeType()
                        + "\nRoast degree: " + product.getRoastDegree())
                .toList();
        return list;
    }

    @Override
    public String getCoffeeWithHighestRating() {
        return null;
    }

    @Override
    public String getCheapestCoffee() {
        return null;
    }
}
