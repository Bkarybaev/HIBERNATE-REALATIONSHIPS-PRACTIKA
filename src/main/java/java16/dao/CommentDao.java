package java16.dao;

import java16.models.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentDao {
    void saveComment(Long postId, Long userId, Comment comment);
    List<Comment> findCommentByPostId(Long postId);
    void updateComment(Long commentId, String newText);
    void deleteComment(Comment comment);
}
