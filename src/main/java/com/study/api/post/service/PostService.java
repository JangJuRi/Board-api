package com.study.api.post.service;

import com.study.api.common.file.entity.File;
import com.study.api.common.file.service.FileService;
import com.study.api.member.entity.Member;
import com.study.api.member.repository.MemberRepository;
import com.study.api.post.entity.Post;
import com.study.api.post.projection.PostInfo;
import com.study.api.post.projection.PostsWithMembers;
import com.study.api.post.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final FileService fileService;

    public Page<PostsWithMembers> loadAllPost(int pageNumber, int pageSize) throws Exception {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return postRepository.findAllBy(pageable);
    }

    public PostInfo loadPostDetail(Long postId) throws Exception {
        return postRepository.findByPostId(postId);
    }

    public void savePost(Post post, MultipartFile file) throws Exception {
        Member member = memberRepository.findById(Long.valueOf(1)).get(); // 로그인 구현 전이라 임시
        post.setMember(member);

        postRepository.save(post);

        File fileEntity = fileService.uploadFile(file, "/post/" + post.getPostId());
        post.setFile(fileEntity);

        postRepository.save(post);

    }

    public void removePost(Map<String, Long> params) throws Exception {
        Long postId = params.get("postId");
        postRepository.deleteById(postId);
    }
}
