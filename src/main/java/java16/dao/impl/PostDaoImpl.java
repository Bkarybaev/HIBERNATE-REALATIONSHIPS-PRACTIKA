package java16.dao.impl;

import jakarta.persistence.EntityManager;
import java16.config.DataBaseConfig;
import java16.dao.PostDao;
import java16.models.Post;
import java16.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostDaoImpl implements PostDao {
    EntityManager em = DataBaseConfig.getEntityManager().createEntityManager();
    @Override
    public void savePost(Long userId, Post post) {
        em.getTransaction().begin();
        em.persist(post);
        User user = em.find(User.class, userId);
        Post post1 = em.find(Post.class, post.getId());
        post1.setOwner(user);
        if(user.getPost() == null) {user.setPost(new ArrayList<>());}
        user.getPost().add(post1);
        em.merge(user);
        em.getTransaction().commit();
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return em.find(User.class, userId).getPost();
    }

    @Override
    public List<Post> searchPost(String query) {
        try {
            List<Post> posts = em
                    .createQuery("select p from Post p where p.description ilike :qwery", Post.class)
                    .setParameter("qwery", '%'+query+'%')
                    .getResultList();
            if (posts != null) {
                return posts;
            }
            return List.of();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePostById(Long id) {
        em.getTransaction().begin();
        Post post = em.find(Post.class, id);
        em.find(User.class, post.getOwner().getId()).setPost(null);
        em.remove(post);
        em.getTransaction().commit();
    }
}
