package com.example.office.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.office.entity1.SalaryRecord;
import com.example.office.repository1.SalaryRecordRepository;

@Service
public class SalaryRecordService
{
	@Autowired
	private SalaryRecordRepository salaryRepo;

	public boolean saveRecord(SalaryRecord salaryRecord) {
		// TODO Auto-genera	
		try {
		salaryRepo.save(salaryRecord);
		salaryRepo.flush();
		return true;
}catch(Exception ex) {
	System.err.println("Save Salary : " + ex.getMessage());
	return false;
}	
}

	public List<SalaryRecord> list() {
		// TODO Auto-generated method stub
		return salaryRepo.findAll();
	}
}
