package com.superhan.springbootboilerplate.users;

import java.util.List;

import javax.transaction.Transactional;

import com.superhan.springbootboilerplate.roles.Role;
import com.superhan.springbootboilerplate.roles.RoleRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
  @Override
  public void addRoleToUser(String username, String roleName) {
    log.info("Adding role {} to user {}", roleName, username);

    User user = userRepository.findByUsername(username);
    Role role = roleRepository.findByName(roleName);
    user.getRoles().add(role);
  }

  @Override
  public User getUser(String username) {
    log.info("Fetching user {}", username);
    return userRepository.findByUsername(username);
  }

  @Override
  public List<User> getUsers() {
    log.info("Fetching all users");
    return userRepository.findAll();
  }

  @Override
  public User saveUser(User user) {
    log.info("Saving new user {} to the databse", user.getName());
    return userRepository.save(user);
  }

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

}
