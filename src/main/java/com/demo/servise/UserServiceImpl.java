package com.demo.servise;

import com.demo.dto.UserDto;
import com.demo.mappers.UserMapper;

import com.demo.models.Role;
import com.demo.models.User;
import com.demo.repository.RoleRepo;
import com.demo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.demo.models.UserStatus.ACTIVE;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User register(User user) {
        // тут нужен мапер для юзера, и дто на вход с параметрами, в маппер засовываем дто, отдает смапленного нового юзера
        // корректно дополняем юзера если нужно и сохраняем его в бд
        Role roleUser = roleRepo.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(ACTIVE);

        var newUser = userRepo.save(user);
        log.info("IN register - user {} successfully registered", newUser);
        return newUser;
    }

    @Override
    public Set<UserDto> getUsersDto() {
        var allUsers = userMapper.mapToSetDto(userRepo.findAll());
        log.info("IN getAll - {} users found", allUsers);
        return allUsers;
    }

    @Override
    public User finByUserName(String userName) {
        var user = userRepo.findByUserName(userName);
        if (Optional.ofNullable(user).isEmpty()) {
            log.info("IN finByUserName - not found by user name {}", userName);
            return null;
        }
        log.info("IN finByUserName - user {} found by user name {}", user, userName);
        return user;
    }

    @Override
    public User findById(Long userId) {
        var user = userRepo.findById(userId);

        if (user.isEmpty()) {
            log.info("IN findById - not found by user id {}", userId);
            return null;
        }
        log.info("IN findById - user {} found by user id {}", user, userId);
        return user.get();
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
        log.info("IN deleteUser - delete by user id {}", id);
    }
}
