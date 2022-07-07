package com.example.office.Controller1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.office.entity1.Employee;
import com.wipro.officeapp2.response.Response;
import com.example.office.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	private EmployeeService empService;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Response> saveEmployee(@RequestBody Employee employee) 
	{
		empService.saveEmployee(employee);
		Response res = new Response(true, employee);
		return ResponseEntity.ok(res);
	}
	
	@GetMapping(value = "/list")
	public ResponseEntity<Response> listEmployee()
	{
		List<Employee> list =  empService.list();
		Response res = new Response(true, list);
		return ResponseEntity.ok(res);
	}
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Response> deleteEmployee(@PathVariable(value = "id") String eid)
	{
		boolean status = empService.deleteEmployee(eid);
		Response res = new Response(status, eid);
		return ResponseEntity.ok(res);
	}
	
}
