package com.study.api.post.service;

import com.study.api.post.dto.PostListResponseDto;
import com.study.api.post.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostListResponseDto> loadAllPost() {
        return postRepository.findAllPosts();
    }
}
