package com.secbapp.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@GetMapping("/login")
	public String login() {
		return "Welcome to the Login Page of Spring App.";
	}
	
	@GetMapping("/register")
	public String register() {
		return "Welcome to the register page";
	}
	
	@PostMapping("/getName")
	public static String getName(@RequestBody String name) {
		return "Welcome ," + name; 
	}
}
