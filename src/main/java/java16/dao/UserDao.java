package java16.dao;

import java16.models.Profile;
import java16.models.User;

import java.util.Optional;

public interface UserDao {
    void save(User user);

    void delete(Long id);

    Optional<User> findById(Long id);

    User updateUserProfile(Long userId, Profile profile);

}
