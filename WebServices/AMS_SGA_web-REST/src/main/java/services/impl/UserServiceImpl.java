package services.impl;

import data.UserDAO;
import domain.User;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import services.interfaces.UserServices;

import java.util.List;

@Stateless
public class UserServiceImpl implements UserServices {

    @Inject
    private UserDAO userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserByUsername(User user) {
        return userDao.findById(user);
    }

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.delete(user);
    }
}