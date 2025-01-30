package java16.service.impl;

import java16.dao.ProfileDao;
import java16.dao.UserDao;
import java16.dao.impl.ProfileDaoImpl;
import java16.dao.impl.UserDaoImpl;
import java16.models.Profile;
import java16.service.ProfileService;

public class ProfileServiceImpl implements ProfileService {
    ProfileDao profileDao = new ProfileDaoImpl();
    UserDao userDao = new UserDaoImpl();

    @Override
    public void save(Long userId, Profile profile) {
        profileDao.save(userId, profile);
    }

    @Override
    public void delete(Long userId) {
        profileDao.delete(userId);
    }

    @Override
    public Profile findProfileByUserId(Long userId) {
        return profileDao.findProfileByUserId(userId).orElse(null);
    }
}
