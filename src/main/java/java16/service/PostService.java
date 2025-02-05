package java16.service;

import java16.models.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    void savePost(Long userId, Post post);
    List<Post> getPostsByUserId(Long userId);
    List<Post>  searchPost(String query);
    void deletePostById(Long id);
}
