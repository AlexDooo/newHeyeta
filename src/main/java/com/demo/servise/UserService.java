package com.demo.servise;

import com.demo.dto.UserDto;
import com.demo.mappers.UserMapper;

import com.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public Set<UserDto> getUsersDto() {
        return userMapper.mapToSetDto(userRepo.findAll().stream()
                .filter(user -> user.getUserAge() >= 18)
                .collect(Collectors.toList()));
    }
}
