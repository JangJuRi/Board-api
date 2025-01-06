package com.study.api.member.entity;

import com.study.api.common.entity.BaseEntity;
import com.study.api.post.entity.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    private Long memberId;
    private String accountId;
    private String name;
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Post> posts;
}
