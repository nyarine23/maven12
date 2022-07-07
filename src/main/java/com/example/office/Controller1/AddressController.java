package com.example.office.Controller1;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.office.entity1.Address;
import com.example.office.repository1.AddresRepository;
import com.wipro.officeapp2.response.Response;

@RestController
@RequestMapping("/address")
public class AddressController
{
	@Autowired
	private AddresRepository addressRepo;
	
	@GetMapping("/list")
	public ResponseEntity<Response> listAddress()
	{
		List<Address> list = addressRepo.findAll();
		Response response = new Response(true, list);
		return ResponseEntity.ok(response);
	}
}