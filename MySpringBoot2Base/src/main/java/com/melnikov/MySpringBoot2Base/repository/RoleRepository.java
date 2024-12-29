package com.melnikov.MySpringBoot2Base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.melnikov.MySpringBoot2Base.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
