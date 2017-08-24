package ru.alexraydev.javaspring07.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import ru.alexraydev.javaspring07.dao.User;
import ru.alexraydev.javaspring07.dao.UsersDAO;

import java.util.List;

@Service("usersService")
public class UsersService {

    private UsersDAO usersDao;

    @Autowired
    public void setUsersDao(UsersDAO usersDao) {
        this.usersDao = usersDao;
    }
    public void createUser(User user) {
        usersDao.create(user);
    }

    public boolean exists(String username) {
        return usersDao.exists(username);
    }

    @Secured("ROLE_ADMIN")
    public List<User> getAllUsers() {
        return usersDao.getAllUsers();
    }
}