package java16.dao.impl;

import jakarta.persistence.EntityManager;
import java16.config.DataBaseConfig;
import java16.dao.CommentDao;
import java16.models.Comment;
import java16.models.Post;
import java16.models.User;

import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl implements CommentDao {
    EntityManager em = DataBaseConfig.getEntityManager().createEntityManager();

    @Override
    public void saveComment(Long postId, Long userId, Comment comment) {
        em.getTransaction().begin();
        User user = em.find(User.class, userId);
        em.persist(comment);
        Comment comment1 = em.find(Comment.class, comment.getId());
        for (Post post1 : user.getPost()) {
            if (post1.getId().equals(postId)) {
                post1.getComments().add(comment1);
                comment1.setPost(post1);
                if (comment1.getUsers() == null) {
                    comment1.setUsers(new ArrayList<>());
                }
                comment1.getUsers().add(user);
                if (user.getComments() == null) {
                    user.setComments(new ArrayList<>());
                }
                user.getComments().add(comment1);
                break;
            }
        }
        em.merge(comment1);
        em.merge(user);
        em.getTransaction().commit();
    }

    @Override
    public List<Comment> findCommentByPostId(Long postId) {
        Post post = em.find(Post.class, postId);
        return post.getComments().stream().toList();
    }

    @Override
    public void updateComment(Long commentId, String newText) {
        em.getTransaction().begin();
        Comment comment = em.find(Comment.class, commentId);
        comment.setText(newText);
        em.merge(comment);
        em.getTransaction().commit();
    }

    @Override
    public void deleteComment(Comment comment) {

    }
}
