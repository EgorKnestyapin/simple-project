//package de.ait.repositories;
//
//import de.ait.models.Product;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UsersRepositoryTextFileImpl implements ProductRepository {
//    String fileName;
//
//    public UsersRepositoryTextFileImpl(String fileName) {
//        this.fileName = fileName;
//    }
//
//    @Override
//    public List<Product> findAll() {
//        List<Product> users = new ArrayList<>();
//        // try-with-resources
//        try (FileReader fileReader = new FileReader(fileName);
//             BufferedReader bf = new BufferedReader(fileReader)) {
//            String line;
//            while ((line = bf.readLine()) != null) {
//                Product user = parseLine(line);
//                users.add(user);
//            }
//
//        } catch (IOException e) {
//            System.out.println("Произошла ошибка");
//        }
//        return null;
//    }
//
//    public static Product parseLine(String line) {
//        String[] strings = line.split("\\|");
//        return new Product(strings[0], strings[1], Integer.parseInt(strings[2]), Double.parseDouble(strings[3]));
//    }
//}
