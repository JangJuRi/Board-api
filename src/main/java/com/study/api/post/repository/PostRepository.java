package com.study.api.post.repository;

import com.study.api.post.projection.PostInfo;
import com.study.api.post.projection.PostsWithMembers;
import com.study.api.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<PostsWithMembers> findAllBy(Pageable pageable);
    PostInfo findByPostId(Long postId);
}
