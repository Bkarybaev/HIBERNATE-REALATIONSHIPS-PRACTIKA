package java16.service;

import java16.models.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    void saveComment(Long postId, Long userId, Comment comment);
    List<Comment> findCommentByPostId(Long postId);
    void updateComment(Long commentId, String newText);
    String deleteComment(Long comment);
}
