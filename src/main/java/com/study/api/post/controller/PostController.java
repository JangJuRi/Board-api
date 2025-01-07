package com.study.api.post.controller;

import com.study.api.post.entity.Post;
import com.study.api.post.projection.PostInfo;
import com.study.api.post.projection.PostsWithMembers;
import com.study.api.post.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/post/list/load")
    public ResponseEntity<Page<PostsWithMembers>> loadAllPost(@RequestParam("pageNumber") int pageNumber,
                                                              @RequestParam("pageSize") int pageSize) throws Exception {
        return ResponseEntity.ok(postService.loadAllPost(pageNumber, pageSize));
    }

    @GetMapping("/post/detail/load/{postId}")
    public ResponseEntity<PostInfo> loadPostDetail(@PathVariable("postId") Long postId) throws Exception {
        return ResponseEntity.ok(postService.loadPostDetail(postId));
    }

    @PostMapping("/post/save")
    public void savePost(@RequestBody Post post) throws Exception {
        postService.savePost(post);
    }

    @PostMapping("/post/remove")
    public void removePost(@RequestBody Map<String, Long> params) throws Exception {
        postService.removePost(params);
    }
}
