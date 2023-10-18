package de.ait.servivces;

import java.util.List;

public interface UsersService {
    List<String> getNames();
    String getSecondNameOfOldest();
}
