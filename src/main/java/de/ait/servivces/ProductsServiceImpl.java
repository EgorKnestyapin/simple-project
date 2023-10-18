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
    public List<String> getCountries() {
        return productRepository.findAll().stream()
//                .map(product -> "Country: " + product.getCountry() + "\nCoffee type: " + product.)
                .map(product -> product.toString())
                .toList();
    }

    @Override
    public String getCoffeeWithHighestRating() {
        return null;
    }
}
