package com.javaserver.server.users.repository;

import com.javaserver.server.users.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
