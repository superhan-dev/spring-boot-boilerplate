package com.superhan.springbootboilerplate.users;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
  private final UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> getUsers() {
    return ResponseEntity.ok().body(userService.getUsers());
  }

  @PostMapping
  public ResponseEntity<User> saveUser(@RequestBody User user) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users").toUriString());
    return ResponseEntity.created(uri).body(userService.saveUser(user));
  }

  @PostMapping("roles/addtouser")
  public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
    userService.addRoleToUser(form.getUsername(), form.getRoleName());
    return ResponseEntity.ok().build();
  }

  // @GetMapping("/{id}")
  // public ResponseEntity<User> getUser(@PathVariable Long id) {
  // return ResponseEntity.ok().body(userService.getUser(id));
  // }
}

@Data
class RoleToUserForm {
  private String username;
  private String roleName;
}