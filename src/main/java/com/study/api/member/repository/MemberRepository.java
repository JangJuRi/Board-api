package com.study.api.member.repository;

import com.study.api.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member, Long> {
}
