package com.example.office.repository1;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.office.entity1.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}