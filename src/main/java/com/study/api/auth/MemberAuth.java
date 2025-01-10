package com.study.api.auth;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash(value = "memberAuth", timeToLive = 86400)
public class MemberAuth {
    @Id
    private String sessionId;

    @Indexed
    private Long memberId;

    public MemberAuth() {}

    public MemberAuth(String sessionId, Long memberId) {
        this.sessionId = sessionId;
        this.memberId = memberId;
    }
}
