package com.superhan.springbootboilerplate.users;

import java.util.List;

import com.superhan.springbootboilerplate.roles.Role;

public interface UserService {
  User saveUser(User user);

  void addRoleToUser(String username, String roleName);

  User getUser(String username);

  List<User> getUsers();

}
