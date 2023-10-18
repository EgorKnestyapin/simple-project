package de.ait.repositories;

import de.ait.models.User;

import java.util.List;

public interface UsersRepository {
    public List<User> findAll();
}
