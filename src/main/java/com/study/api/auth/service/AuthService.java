package com.study.api.auth.service;

import com.study.api.auth.MemberAuth;
import com.study.api.auth.dto.AuthRequest;
import com.study.api.auth.repository.AuthRepository;
import com.study.util.CommonUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public String saveAuth(AuthRequest authRequest) {
        String sessionId = UUID.randomUUID().toString(); // sessionId 생성
        MemberAuth memberAuth = new MemberAuth(sessionId, authRequest.getMemberId());
        authRepository.save(memberAuth);

        return sessionId;
    }

    public void logout(Map<String, String> params) {
        authRepository.deleteById(CommonUtil.NVL(params.get("sessionId")));
    }
}
