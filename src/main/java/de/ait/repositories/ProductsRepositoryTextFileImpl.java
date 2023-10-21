package de.ait.repositories;

import de.ait.models.CoffeeType;
import de.ait.models.Product;
import de.ait.models.RoastDegree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsRepositoryTextFileImpl implements ProductsRepository {
    String fileName;

    public ProductsRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        // try-with-resources
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bf = new BufferedReader(fileReader)) {
            String line;
            while ((line = bf.readLine()) != null) {
                Product user = parseLine(line);
                products.add(user);
            }

        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }
        return products;
    }

    @Override
    public String save(Product product) {
        String str = product.getProductId() + "|" + product.getCountry() + "|" + product.getRoastDegree() + "|"
                + product.getCoffeeType() + "|" + product.getPricePer100Gr() + "|" + product.getRating() + "|"
                + product.isAvailable() + "\n";
        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter bf = new BufferedWriter(fileWriter)) {
            bf.write(str);
        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }
        return str;
    }

    @Override
    public Product deleteById(String id) {
        Product productDeleted = null;
        copyFile(fileName, "temp.txt");
        try (BufferedReader br = new BufferedReader(new FileReader("temp.txt"));
             BufferedWriter bf = new BufferedWriter(new FileWriter(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.split("\\|")[0].equals(id)) {
                    productDeleted = parseLine(line);
                    continue;
                }
                bf.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        clearFile("temp.txt");
        return productDeleted;
    }

    private void copyFile(String from, String to) {
        try (BufferedReader br = new BufferedReader(new FileReader(from));
             BufferedWriter bf = new BufferedWriter(new FileWriter(to))) {
            br.transferTo(bf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearFile(String fileName) {
        try(BufferedWriter bf = new BufferedWriter(new FileWriter(fileName))) {
            bf.write("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Product parseLine(String line) {
        String[] strings = line.split("\\|");
        return new Product(strings[0], strings[1], RoastDegree.valueOf(strings[2]), CoffeeType.valueOf(strings[3]),
                Double.parseDouble(strings[4]), Double.parseDouble(strings[5]), Boolean.parseBoolean(strings[6]));
    }
}
