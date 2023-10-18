package de.ait.repositories;

import de.ait.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryListImpl implements UsersRepository {
    private List<User> users = new ArrayList<>(List.of(
            new User("Alisher", "Khamidov", 29, 1.72),
            new User("TestName1", "FamilyT1", 25, 1.99),
            new User("TestName2", "FamilyT2", 36, 1.8)
    ));
    @Override
    public List<User> findAll() {
        return users;
    }
}
