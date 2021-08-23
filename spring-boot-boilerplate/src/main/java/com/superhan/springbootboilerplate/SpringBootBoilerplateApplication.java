package com.superhan.springbootboilerplate;

import java.util.ArrayList;

import com.superhan.springbootboilerplate.roles.Role;
import com.superhan.springbootboilerplate.roles.RoleService;
import com.superhan.springbootboilerplate.users.User;
import com.superhan.springbootboilerplate.users.UserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootBoilerplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBoilerplateApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService, RoleService roleService) {
		return args -> {
			roleService.saveRole(new Role(null, "ROLE_USER"));
			roleService.saveRole(new Role(null, "ROLE_MANAGER"));
			roleService.saveRole(new Role(null, "ROLE_ADMIN"));
			roleService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John Dow", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Ben Han", "ben", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Carry Chio", "carry", "1234", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("ben", "ROLE_MANAGER");
			userService.addRoleToUser("ben", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("carry", "ROLE_ADMIN");
		};
	}
}
