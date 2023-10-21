package de.ait.repositories;

import de.ait.models.Product;

import java.util.List;

public interface ProductsRepository {
    List<Product> findAll();

    String save(Product product);

    Product deleteById(String id);
}
