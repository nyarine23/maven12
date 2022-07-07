package com.example.office;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.office.entity1.Role;
import com.example.office.entity1.Users;
import com.example.office.service.RoleService;
import com.example.office.service.UserService;

@SpringBootApplication
public class OfficeApp5Application implements CommandLineRunner{
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(OfficeApp5Application.class, args);
	}
		@Override
		public void run(String... args) throws Exception 
		{
			if(!userService.isExistByName("admin"))
			{
				Role rol1 = new Role();
				rol1.setName("ROLE_OFFICE_ADMIN");
				Role rol2 = new Role();
				rol2.setName("ROLE_OFFICE_MANAGER");
				Role rol3 = new Role();
				rol3.setName("ROLE_OFFICE_HR");
				
				Set<Role> roles = new HashSet<>();
				roles.add(rol1);
				
				BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
				
				Users user = new Users();
				user.setEmail("admin@gmail.com");
				user.setPassword(encode.encode("12345"));
				user.setUsername("admin");
				user.setRoles(roles);
				
//				roleService.saveRole(rol1);
				roleService.saveRole(rol2);
				roleService.saveRole(rol3);
				userService.saveUser(user);
			}
	
		}
	
}
