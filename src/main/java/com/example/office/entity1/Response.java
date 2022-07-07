package com.example.office.entity1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response 
{
	private boolean status;
	private Object data;
}