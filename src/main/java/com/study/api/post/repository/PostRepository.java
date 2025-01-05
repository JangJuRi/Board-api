package com.study.api.post.repository;

import com.study.api.post.dto.PostListResponseDto;
import com.study.api.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("select new com.study.api.post.dto.PostListResponseDto(p) from Post p inner join p.member m")
    List<PostListResponseDto> findAllPosts();
}
