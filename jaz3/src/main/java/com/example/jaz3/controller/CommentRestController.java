package com.example.jaz3.controller;

import com.example.jaz3.model.Comment;
import com.example.jaz3.model.ResourceNotFoundException;
import com.example.jaz3.repo.CommentRepository;
import com.example.jaz3.repo.PartRepository;
import com.example.jaz3.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;


@RestController
public class CommentRestController {

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentServiceImpl commentService;

    public void setCommentService(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }
    @GetMapping("/api/comments/{partId}")
    public Page<Comment> getAllCommentsByPostId(@PathVariable (value = "partId") Long partId,
                                                Pageable pageable) {
        return commentRepository.findByPartId(partId, pageable);
    }
    @PostMapping("/api/comments")
    public void saveComment(Comment comment){
        commentService.saveComment(comment);
        System.out.println("Komentarz dodany pomyslnie");
    }
    @DeleteMapping("/api/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
        System.out.println("Komentarz usuniety pomyslnie");
    }
    @PutMapping("/api/comments/{partId}/{commentId}")
    public Comment updateComment(@PathVariable (value = "partId") Long partId,
                           @PathVariable (value = "commentId") Long commentId,
                           @Valid @RequestBody Comment commentRequest) {
        if(!partRepository.existsById(partId)) {
            throw new ResourceNotFoundException("PostId " + partId + " not found");
        }

        return commentRepository.findById(commentId).map(comment -> {
            comment.setContent(commentRequest.getContent());
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));

    }
}
