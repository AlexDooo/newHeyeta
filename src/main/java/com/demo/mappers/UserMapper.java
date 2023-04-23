package com.demo.mappers;

import com.demo.dto.UserDto;
import com.demo.models.User;

import java.util.List;
import java.util.Set;


public interface UserMapper {

    UserDto mapToDto(User user);

    Set<UserDto> mapToSetDto(List<User> users);
}
