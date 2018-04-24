package ru.itis.webappcdio.service;

/**
 * Created by 1 on 04.05.2017.
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);

}

