package com.study.api.member.controller;

import com.study.api.member.entity.Member;
import com.study.api.member.projection.MemberSession;
import com.study.api.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/account-id/duplicate/load/{accountId}")
    public ResponseEntity<Boolean> loadAccountIdDuplicate(@PathVariable("accountId") String accountId) throws Exception {
        return ResponseEntity.ok(memberService.loadAccountIdDuplicate(accountId));
    }

    @PostMapping("/member/signup")
    public void signup(@RequestBody Member member) throws Exception {
        memberService.signup(member);
    }

    @PostMapping("/member/login")
    public ResponseEntity<MemberSession> login(@RequestBody Member member) throws Exception {
        return ResponseEntity.ok(memberService.login(member));
    }
}
