package de.ait.repositories;

import de.ait.models.CoffeeType;
import de.ait.models.Product;
import de.ait.models.RoastDegree;

import java.util.ArrayList;
import java.util.List;

public class ProductsRepositoryListImpl implements ProductsRepository {
    private List<Product> products = new ArrayList<>(List.of(
            new Product("1", "Brazil", RoastDegree.LIGHT, CoffeeType.ARABICA, 5.5, 4.1, true),
            new Product("2", "Columbia", RoastDegree.MIDDLE, CoffeeType.HYBRID, 4, 4, true),
            new Product("3", "Jordan", RoastDegree.DARK, CoffeeType.ROBUSTA, 2, 3.2, true),
            new Product("4", "Kenya", RoastDegree.LIGHT, CoffeeType.DECAF, 4.8, 3.8, false)
    ));
    @Override
    public List<Product> findAll() {
        return products;
    }
}
