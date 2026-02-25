package com.secbapp.app.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.secbapp.app.models.Admin;
import com.secbapp.app.models.Student;
import com.secbapp.app.services.AdminService;

public class AdminController {
	@Autowired
	AdminService adminService;
	
	
	//Create
	@PostMapping("/admin/register")
	public Admin newAdmin(@RequestBody Admin newAdmin) {
		return adminService.adminRegister(newAdmin);
	}
	
	@PostMapping("/admin/login/{id}")
	public String adminLogin(int id, Map<String, String> adminLogin) {
		return adminService.adminLogin(id, adminLogin.get("email"), adminLogin.get("pass"));
	}
	//Read All
	@GetMapping("/admin/show_all")
	public ArrayList<Student> readAll() {
		return adminService.viewAll();	
	}
	
}
