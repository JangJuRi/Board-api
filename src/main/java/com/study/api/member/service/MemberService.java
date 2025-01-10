package com.study.api.member.service;

import com.study.api.member.entity.Member;
import com.study.api.member.projection.MemberLoginInfo;
import com.study.api.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Boolean loadAccountIdDuplicate(String accountId) {
        return memberRepository.existsByAccountId(accountId);
    }

    public void signup(Member member) {
        memberRepository.save(member);
    }

    public MemberLoginInfo login(Member member) {
        String accountId = member.getAccountId();
        String password = member.getPassword();
        return memberRepository.findMemberByAccountIdAndPassword(accountId, password);
    }
}
