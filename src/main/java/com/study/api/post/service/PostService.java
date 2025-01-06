package com.study.api.post.service;

import com.study.api.post.projection.PostInfo;
import com.study.api.post.projection.PostsWithMembers;
import com.study.api.post.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostsWithMembers> loadAllPost() throws Exception {
        return postRepository.findAllBy();
    }

    public PostInfo loadPostDetail(Long postId) throws Exception {
        return postRepository.findByPostId(postId);
    }
}
