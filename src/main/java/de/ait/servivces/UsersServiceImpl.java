package de.ait.servivces;

import de.ait.models.User;
import de.ait.repositories.UsersRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class UsersServiceImpl implements UsersService {
    UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<String> getNames() {
        List<User> users = usersRepository.findAll();
        return users.stream()
                .map(User::getFirstName)
                .toList();
    }

    @Override
    public String getSecondNameOfOldest() {
        List<User> users = usersRepository.findAll();
        String secondName = users.stream()
                .max((a, b) -> Integer.compare(b.getAge(), a.getAge()))
                .orElseThrow(NoSuchElementException::new)
                .getSecondName();
        return secondName;
    }
}
