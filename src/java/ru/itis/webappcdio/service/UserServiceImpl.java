package ru.itis.webappcdio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.webappcdio.dao.RoleDao;
import ru.itis.webappcdio.dao.UserDao;
import ru.itis.webappcdio.model.Role;
import ru.itis.webappcdio.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 1 on 04.05.2017.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }
    @Override
    public User findByUsername(String  username){
        return userDao.findByUsername(username);
    }
}
