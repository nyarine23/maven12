package com.example.office.repository1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.office.entity1.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>
{

}