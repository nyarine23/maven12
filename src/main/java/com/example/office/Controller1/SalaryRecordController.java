package com.example.office.Controller1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.office.entity1.Employee;
import com.example.office.entity1.SalaryRecord;
import com.example.office.modela.SalaryRecordModel;
import com.wipro.officeapp2.response.Response;
import com.example.office.service.EmployeeService;
import com.example.office.service.SalaryRecordService;
@RestController
@RequestMapping("/empsalary")
public class SalaryRecordController {
	@Autowired
	private SalaryRecordService salaryService;
	

	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/save")
	public ResponseEntity<Response> save(@RequestBody SalaryRecordModel record)
	{
		Optional<Employee> op = empService.get(record.getEmployeeId());
		if(op.isEmpty())
		{
			return ResponseEntity.badRequest().body(new Response(false, "Invalid Employee !"));
		}else {
			Employee emp = op.get();
			SalaryRecord salaryRecord = new SalaryRecord(record,emp);
			boolean status = salaryService.saveRecord(salaryRecord);
			return ResponseEntity.badRequest().body(new Response(status, salaryRecord));

		}
}
	@GetMapping(value = "/list")
	public ResponseEntity<Response> list()
	{
		List<SalaryRecord> list =  salaryService.list();
		Response res = new Response(true, list);
		return ResponseEntity.ok(res);
	}
}
