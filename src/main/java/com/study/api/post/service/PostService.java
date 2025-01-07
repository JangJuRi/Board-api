package com.study.api.post.service;

import com.study.api.member.entity.Member;
import com.study.api.member.repository.MemberRepository;
import com.study.api.post.entity.Post;
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
    private final MemberRepository memberRepository;

    public List<PostsWithMembers> loadAllPost() throws Exception {
        return postRepository.findAllBy();
    }

    public PostInfo loadPostDetail(Long postId) throws Exception {
        return postRepository.findByPostId(postId);
    }

    public void savePost(Post post) throws Exception {
        Member member = memberRepository.findById(Long.valueOf(1)).get(); // 로그인 구현 전이라 임시
        post.setMember(member);
        postRepository.save(post);
    }
}
