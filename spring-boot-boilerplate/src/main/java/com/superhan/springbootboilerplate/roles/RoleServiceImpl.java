package com.superhan.springbootboilerplate.roles;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  @Override
  public Role saveRole(Role role) {
    log.info("Saving new role {} to the databse", role.getName());

    return roleRepository.save(role);
  }
}
