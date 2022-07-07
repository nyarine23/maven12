package com.example.office.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.office.entity1.Role;
import com.example.office.repository1.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepo;
	
	public boolean saveRole(Role role) 
	{
		try{
			roleRepo.save(role);
			
			return true;
		}catch(Exception ex) {
			System.err.println("Role Save Error : "+ex.getMessage());
			return false;
		}
	}
}
