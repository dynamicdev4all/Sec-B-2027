package com.secbapp.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secbapp.app.models.Student;
import com.secbapp.app.repositories.StudentRepository;

@Service
public class StudentService {
//	StudentRepository repo = new StudentRepository();
	@Autowired
	StudentRepository repo;
	
	public Student register(Student newStudent) {
		return repo.register(newStudent);
	}
	public void login() {
		
	}
	public void resetAccount() {
		
	}
	public void showMarks() {
		
	}
	public Student delete(int id) {
		return repo.removeUser(id);
	}
	
	public Student readOne(int id) {
		return repo.readOne(id);
	}
	
	public Student update(int id, Student updatedStudent) {
		return repo.updateData(id, updatedStudent);
	}
}
