package com.study.api.post.entity;

import com.study.api.common.base.entity.BaseEntity;
import com.study.api.common.file.entity.File;
import com.study.api.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

    @Id @GeneratedValue
    private Long postId;
    private String title;
    private String subTitle;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fileId")
    private File file;
}
