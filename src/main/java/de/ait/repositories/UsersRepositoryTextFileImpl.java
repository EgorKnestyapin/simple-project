package de.ait.repositories;

import de.ait.models.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryTextFileImpl implements UsersRepository {
    String fileName;

    public UsersRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        // try-with-resources
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bf = new BufferedReader(fileReader)) {
            String line;
            while ((line = bf.readLine()) != null) {
                User user = parseLine(line);
                users.add(user);
            }

        } catch (IOException e) {
            System.out.println("Произошла ошибка");
        }
        return null;
    }

    public static User parseLine(String line) {
        String[] strings = line.split("\\|");
        return new User(strings[0], strings[1], Integer.parseInt(strings[2]), Double.parseDouble(strings[3]));
    }
}