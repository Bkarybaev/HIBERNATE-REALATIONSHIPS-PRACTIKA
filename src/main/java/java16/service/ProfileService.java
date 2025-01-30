package java16.service;

import java16.models.Profile;

import java.util.Optional;

public interface ProfileService {
    void save(Long userId , Profile profile);
    void delete(Long userId);
    Profile findProfileByUserId(Long userId);
}
