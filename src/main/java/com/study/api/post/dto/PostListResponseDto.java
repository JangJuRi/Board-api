package com.study.api.post.dto;

import com.study.api.post.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter

public class PostListResponseDto {
    private Long postId;
    private String title;
    private String content;
    private String memberName;
    private String createdDate;

    public PostListResponseDto(Post post) {
        this.postId = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.memberName = post.getMember().getName();
        this.createdDate = post.getCreatedDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }
}
