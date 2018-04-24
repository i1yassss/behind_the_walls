package ru.itis.webappcdio.service;

import ru.itis.webappcdio.model.User;

/**
 * Created by 1 on 04.05.2017.
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
