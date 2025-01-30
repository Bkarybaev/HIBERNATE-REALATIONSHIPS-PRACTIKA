package java16.service.impl;

import java16.dao.impl.UserDaoImpl;
import java16.models.Profile;
import java16.models.User;
import java16.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public void save(User user) {
        try {
            userDao.save(user);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public User updateUserProfile(Long userId, Profile profile) {
      return   userDao.updateUserProfile(userId, profile);
    }
}
