package java16.service.impl;

import java16.dao.impl.PostDaoImpl;
import java16.models.Post;
import java16.service.PostService;

import java.util.List;
import java.util.Optional;

public class PostServiceImpl implements PostService {
    PostDaoImpl dao = new PostDaoImpl();
    @Override
    public void savePost(Long userId, Post post) {
        dao.savePost(userId, post);
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return dao.getPostsByUserId(userId);
    }

    @Override
    public Optional<Post> searchPost(String query) {
        return Optional.empty();
    }

    @Override
    public void deletePostById(Long id) {
        dao.deletePostById(id);
    }
}
