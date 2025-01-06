package com.study.api.post.projection;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface PostsWithMembers {
    Long getPostId();
    String getTitle();
    String getSubTitle();
    String getContent();
    LocalDateTime getCreatedDate();

    @Value("#{target.member.name}")
    String getMemberName();

    default String getFormattedCreatedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return getCreatedDate().format(formatter);
    }
}
