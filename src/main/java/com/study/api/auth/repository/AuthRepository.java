package com.study.api.auth.repository;

import com.study.api.auth.MemberAuth;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends CrudRepository<MemberAuth, String> {
}
