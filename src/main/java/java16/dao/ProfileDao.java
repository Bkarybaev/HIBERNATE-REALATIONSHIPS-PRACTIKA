package java16.dao;

import java16.models.Profile;

import java.util.Optional;

public interface ProfileDao {
    void save(Long userId ,Profile profile);
    void delete(Long userId);
    Optional<Profile> findProfileByUserId(Long userId);

}
