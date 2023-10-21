package de.ait.repositories;

import de.ait.models.CoffeeType;
import de.ait.models.Product;
import de.ait.models.RoastDegree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductsRepositoryListImpl implements ProductsRepository {
    private List<Product> products;
    public ProductsRepositoryListImpl(List<Product> products) {
        this.products = products;
    }

    public ProductsRepositoryListImpl() {
        products = new ArrayList<>(List.of(
                new Product(UUID.randomUUID().toString(), "Brazil", RoastDegree.LIGHT, CoffeeType.ARABICA,
                        5.5, 4.1, true),
                new Product(UUID.randomUUID().toString(), "Jordan", RoastDegree.DARK, CoffeeType.ROBUSTA,
                        2, 3.2, true),
                new Product(UUID.randomUUID().toString(), "Columbia", RoastDegree.MIDDLE, CoffeeType.HYBRID,
                        4, 4, true),
                new Product(UUID.randomUUID().toString(), "Kenya", RoastDegree.LIGHT, CoffeeType.DECAF,
                        4.8, 3.8, false)
        ));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public String save(Product product) {
        products.add(product);
        return product.toString();
    }

    @Override
    public Product deleteById(String id) {
        Optional<Product> productDeleted = products.stream()
                .filter(product -> product.getProductId().equals(id))
                .findFirst();
        products.remove(productDeleted.orElse(null));
        return productDeleted.orElse(null);
    }
}
