package com.secbapp.app.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.secbapp.app.models.Student;
import com.secbapp.app.services.AdminService;
import com.secbapp.app.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	@Autowired
	AdminService service2;
	
	
	//Create
	@PostMapping("/student/register")
	public Student newStudent(@RequestBody Student newStudent) {
		return service.register(newStudent);
	}
	
	//Read All
	@GetMapping("/admin/show_all")
	public ArrayList<Student> readAll() {
		return service2.viewAll();	
	}
	
	//Read One
	public Student readOne(int id) {
		return service.readOne(id);
	}
	
	//Update
	public Student updateStudent(int id, Student updatedStudent) {
		return service.update(id, updatedStudent);
	}
	
	//Delete
	public void deleteStudent(int id) {
		
	}
}
