package com.wipro.officeapp2.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response 
{
	private boolean status;
	private Object data;
}