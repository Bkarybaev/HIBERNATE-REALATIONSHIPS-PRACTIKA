package java16.service;

import java16.models.Profile;
import java16.models.User;

import java.util.Optional;

public interface UserService {
    void save(User user);
    void delete(Long id);
   User findById(Long id);

   User updateUserProfile(Long userId, Profile profile);
}
