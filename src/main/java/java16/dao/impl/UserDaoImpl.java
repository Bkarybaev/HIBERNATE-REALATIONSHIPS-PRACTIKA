package java16.dao.impl;

import jakarta.persistence.EntityManager;
import java16.config.DataBaseConfig;
import java16.dao.UserDao;
import java16.models.Profile;
import java16.models.User;

import java.util.Optional;

public class UserDaoImpl implements UserDao {
    EntityManager entityManager = DataBaseConfig.getEntityManager().createEntityManager();

    @Override
    public void save(User user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        }catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(User.class, id));
        entityManager.getTransaction().commit();
    }



    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public User updateUserProfile(Long userId, Profile profile) {
        User user = entityManager.find(User.class, userId);

       entityManager.getTransaction().begin();
        Profile profile1 = entityManager.find(Profile.class, user.getProfile().getId());
        profile1.setBiography(profile.getBiography());
        profile1.setGender(profile.getGender());
        profile1.setBirthDate(profile.getBirthDate());
        profile1.setFullName(profile.getFullName());
        user.setProfile(profile1);
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        return user;
    }


}
