package com.study.api.post.repository;

import com.study.api.post.projection.PostsWithMembers;
import com.study.api.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<PostsWithMembers> findAllBy();
}
