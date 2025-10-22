package com.reddit.dto;
import com.reddit.model.Comment;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class CommentResponseDto {
    private Long id;
    private Long postId;
    private Long userId;
    private Long parentCommentId;
    private String content;
    private LocalDate createdAt;

    public static CommentResponseDto entityToDto(Comment comment){
        CommentResponseDto dto = new CommentResponseDto();
        dto.setId(comment.getId());
        dto.setPostId(comment.getPost().getId());
//      dto.setUserId(comment);
        dto.setParentCommentId(comment.getParentComment().getId());
        dto.setContent(comment.getContent());
        dto.setCreatedAt(comment.getCreatedAt());
        return dto;
    }
}
