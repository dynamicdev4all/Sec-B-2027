package com.secbapp.app.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.secbapp.app.models.Student;

@RestController
public class StudentController {
	
	Map<Integer, Student> db = new HashMap<Integer, Student>();
	
	int current = 1;
	
	//Create
	@PostMapping("/student/register")
	public Student newStudent(@RequestBody Student newStudent) {
		db.put(current, newStudent);
		current ++;
		return newStudent;
	}
	
	//Read All
	@GetMapping("/student/show_all")
	public ArrayList<Student> readAll() {
		ArrayList<Student> list = new ArrayList<Student>();
		db.values();
		db.keySet();
		list.addAll(db.values());
		return list;
//		db.values();
	}
	
	//Read One
	public Student readOne(int id) {
		return db.get(id);
	}
	
	//Update
	public Student updateStudent(int id, Student updatedStudent) {
		if(!db.containsKey(id)) {
			System.out.println("User does not exist in the database, please register first");
			return null;
		}
		 updatedStudent.setUid(id);
		 return updatedStudent;
	}
	
	//Delete
	public void deleteStudent(int id) {
		db.remove(id);
	}
}
