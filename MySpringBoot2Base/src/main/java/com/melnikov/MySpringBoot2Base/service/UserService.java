package com.melnikov.MySpringBoot2Base.service;

import com.melnikov.MySpringBoot2Base.dto.UserDto;
import com.melnikov.MySpringBoot2Base.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
