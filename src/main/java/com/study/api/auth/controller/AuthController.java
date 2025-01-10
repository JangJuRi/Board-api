package com.study.api.auth.controller;

import com.study.api.auth.dto.AuthRequest;
import com.study.api.auth.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/save")
    public ResponseEntity<String> saveAuth(@RequestBody AuthRequest authRequest) throws Exception {
        return ResponseEntity.ok(authService.saveAuth(authRequest));
    }

    @PostMapping("/auth/logout")
    public void logout(@RequestBody Map<String, String> params) throws Exception {
        authService.logout(params);
    }
}
