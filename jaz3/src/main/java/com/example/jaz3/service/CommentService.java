package com.example.jaz3.service;

import com.example.jaz3.model.Comment;
import com.example.jaz3.model.Part;

import java.util.List;

public interface CommentService {
    public List<Comment> getComments(Long partId);
    public Comment getComment(Long commentId);
    public void saveComment(Comment comment);
    public void deleteComment(Long commentId);
   /* public updateComment(Comment comment);*/
}
