package com.demo.servise;

import com.demo.dto.UserDto;
import com.demo.models.User;

import java.util.Set;

public interface UserService {

    User register(User user);

    Set<UserDto> getUsersDto();

    Object finByUserName(String userName);

    User findById(Long userId);

    void deleteUser(Long id);
}
