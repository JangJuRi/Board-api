package com.study.api.post.controller;

import com.study.api.post.dto.PostListResponseDto;
import com.study.api.post.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/post/list/load")
    public ResponseEntity<List<PostListResponseDto>> loadAllPost() throws Exception {
        return ResponseEntity.ok(postService.loadAllPost());
    }
}
