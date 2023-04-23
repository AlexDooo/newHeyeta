package com.demo.mappers;

import com.demo.dto.UserDto;
import com.demo.models.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.util.CollectionUtils.isEmpty;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto mapToDto(User user) {
        return new UserDto().setId(user.getId())
                .setName(user.getName())
                .setAge(user.getAge())
                .setPassportNumber(user.getPassportNumber());
    }

    @Override
    public Set<UserDto> mapToSetDto(List<User> users) {
        if (isEmpty(users)) {
            return new HashSet<>();
        }
        return users.stream()
                .map(this::mapToDto)
                .collect(Collectors.toSet());
    }
}
