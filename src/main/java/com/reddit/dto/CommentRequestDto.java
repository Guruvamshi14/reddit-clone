package com.reddit.dto;
import com.reddit.model.Comment;
import com.reddit.model.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    private Long postId;
    private Long parentCommentId;
    private String content;

    public static Comment dtoToEntity(CommentRequestDto commentRequestDto, Post post, Comment parentComment){
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setParentComment(parentComment);
        comment.setContent(commentRequestDto.getContent());
        return comment;
    }
}
