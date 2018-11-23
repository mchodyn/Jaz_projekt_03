package com.example.jaz3.service;

import com.example.jaz3.model.Comment;
import com.example.jaz3.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getComments(Long partId) {
        List<Comment> allComments = commentRepository.findAll();
        List<Comment> partComments = new ArrayList<>();
         for(Comment com:allComments) {
             if(com.getPart().getId()==partId){
                 partComments.add(com);

             }
         }

        return partComments;
    }

    @Override
    public Comment getComment(Long commentId) {
        Comment comment =new Comment();
        List<Comment> allComments = commentRepository.findAll();
         for (Comment com:allComments) {
             if(com.getId()==commentId){
                 comment=com;
             }
         }
        return comment;
    }

    @Override
    public void saveComment(Comment comment) {
    commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
    commentRepository.deleteById(commentId);
    }

   /* @Override
    public updateComment(Comment comment) {
    commentRepository.save(comment);
    }*/
}
