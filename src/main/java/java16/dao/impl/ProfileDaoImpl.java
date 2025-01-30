package java16.dao.impl;

import jakarta.persistence.EntityManager;
import java16.config.DataBaseConfig;
import java16.dao.ProfileDao;
import java16.models.Profile;
import java16.models.User;

import java.util.Optional;

public class ProfileDaoImpl implements ProfileDao {
    EntityManager entityManager = DataBaseConfig.getEntityManager().createEntityManager();

    @Override
    public void save(Long userId, Profile profile) {
        try {
            entityManager.getTransaction().begin();
            User user = entityManager.find(User.class, userId);
            user.setProfile(profile);
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Long userId) {
        entityManager.getTransaction().begin();

        User user = entityManager.find(User.class, userId);
        Profile profile = user.getProfile();
        user.setProfile(null);
        entityManager.merge(user);
        entityManager.remove(profile);
        entityManager.getTransaction().commit();

    }

    @Override
    public Optional<Profile> findProfileByUserId(Long userId) {
        User user = entityManager.find(User.class, userId);
        return Optional.ofNullable(user.getProfile());
    }
}
