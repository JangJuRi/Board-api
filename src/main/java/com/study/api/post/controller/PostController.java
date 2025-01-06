package com.study.api.post.controller;

import com.study.api.post.projection.PostInfo;
import com.study.api.post.projection.PostsWithMembers;
import com.study.api.post.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/post/list/load")
    public ResponseEntity<List<PostsWithMembers>> loadAllPost() throws Exception {
        return ResponseEntity.ok(postService.loadAllPost());
    }

    @GetMapping("/post/detail/load/{postId}")
    public ResponseEntity<PostInfo> loadPostDetail(@PathVariable("postId") Long postId) throws Exception {
        return ResponseEntity.ok(postService.loadPostDetail(postId));
    }
}
