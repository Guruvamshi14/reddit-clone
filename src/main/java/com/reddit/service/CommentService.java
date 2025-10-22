package com.reddit.service;

import com.reddit.dto.CommentRequestDto;
import com.reddit.model.Comment;
import com.reddit.model.CommentVote;
import com.reddit.model.Post;
import com.reddit.repo.CommentRepo;
import com.reddit.repo.CommentVoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepo commentRepo;
    private CommentVoteRepo commentVoteRepo;

    @Autowired
    public CommentService(CommentRepo commentRepo, CommentVoteRepo commentVoteRepo){
        this.commentRepo = commentRepo;
        this.commentVoteRepo = commentVoteRepo;
    }

    public Comment createComment(CommentRequestDto commentRequestDto){
        Post post = new Post();
        Comment parentComment = commentRepo.findById(commentRequestDto.getParentCommentId())
                .orElseThrow(()-> new RuntimeException("Parent comment not present"));
        Comment comment = CommentRequestDto.dtoToEntity(commentRequestDto,post,parentComment);
        CommentVote vote = new CommentVote();
        vote.setComment(comment);
        commentVoteRepo.save(vote);
        return commentRepo.save(comment).orElseThrow(()-> new RuntimeException("Comment not saved!"));
    }
}
