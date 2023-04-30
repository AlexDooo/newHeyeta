package com.demo.servise;

import com.demo.dto.UserDto;
import com.demo.models.User;

import java.util.Set;

public interface UserService {

    User register(User user);

    Set<UserDto> getUsersDto();

    User finByUserName(String userName);

    UserDto findById(Long userId);

    void deleteUser(Long id);
}
