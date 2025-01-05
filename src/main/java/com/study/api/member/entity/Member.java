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
    @Column(name = "member_id")
    private Long id;
    private String accountId;
    private String name;
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Post> posts;
}
