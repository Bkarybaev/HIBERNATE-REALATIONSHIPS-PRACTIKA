package java16.service.impl;

import java16.dao.CommentDao;
import java16.dao.impl.CommentDaoImpl;
import java16.models.Comment;
import java16.service.CommentService;

import java.util.List;
import java.util.Optional;

public class CommentServiceImpl implements CommentService {
    CommentDao commentDao = new CommentDaoImpl();

    @Override
    public void saveComment(Long postId, Long userId, Comment comment) {
        commentDao.saveComment(postId, userId, comment);
    }

    @Override
    public List<Comment> findCommentByPostId(Long postId) {
        return commentDao.findCommentByPostId(postId);
    }

    @Override
    public void updateComment(Long commentId, String newText) {
        commentDao.updateComment(commentId, newText);
    }

    @Override
    public void deleteComment(Comment comment) {

    }
}
