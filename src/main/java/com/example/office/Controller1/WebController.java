package com.example.office.Controller1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController 
{
	@GetMapping("/")
	public String home() {
		return "Welcome Office App";
	}
}