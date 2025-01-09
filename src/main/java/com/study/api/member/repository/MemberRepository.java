package com.study.api.member.repository;

import com.study.api.member.entity.Member;
import com.study.api.member.projection.MemberSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member, Long> {
    boolean existsByAccountId(String accountId);
    MemberSession findMemberByAccountIdAndPassword(String accountId, String password);
}
