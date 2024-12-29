package com.melnikov.MySpringBoot2Base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.melnikov.MySpringBoot2Base.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
