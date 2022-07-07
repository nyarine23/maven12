package com.example.office.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.example.office.entity1.Employee;
import com.example.office.repository1.AddresRepository;
import com.example.office.repository1.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private AddresRepository addresRepo;
	
	public boolean saveEmployee(Employee emp) 
	{
		try {
			addresRepo.save(emp.getAddress());
				empRepo.save(emp);
				empRepo.flush();
				return true;
		}catch(Exception ex) {
			System.err.println("Save Emp Error : " + ex.getMessage());
			return false;
		}
	}
	
	public List<Employee> list(){
		return empRepo.findAll();
	}
	
	public boolean deleteEmployee(String eid) 
	{
		try {
				empRepo.deleteById(eid);
				empRepo.flush();
				return true;
		}catch(Exception ex) {
			System.err.println("Del Emp Error : " + ex.getMessage());
			return false;
		}
	}

	public Optional<Employee> get(String employeeId) {
		// TODO Auto-generated method stub
		return empRepo.findById(employeeId);
	}

}