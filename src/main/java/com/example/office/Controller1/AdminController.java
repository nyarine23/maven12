package com.example.office.Controller1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.office.config1.TokenProvider;
import com.example.office.modela.LoginUser;
import com.wipro.officeapp2.response.Response;

@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenProvider jwtTokenUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<Response> authenticate(@RequestBody LoginUser loginUser)
	{
		try {
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginUser.getUsername(),
						loginUser.getPassword()
				)
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String token = jwtTokenUtil.generateToken(authentication);
		return ResponseEntity.ok(new Response(true, token));
		}catch(BadCredentialsException ex) {
			return ResponseEntity.badRequest().body(new Response(false, "Invalid User ID or Pasword"));
		}
	}
}

