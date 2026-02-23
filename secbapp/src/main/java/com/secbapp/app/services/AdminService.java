package com.secbapp.app.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.secbapp.app.models.Student;
import com.secbapp.app.repositories.StudentRepository;

public class AdminService {
	
	@Autowired
	StudentRepository repo;

	public void deleteAccount() {
		
	}
	
	public ArrayList<Student> viewAll() {
		return repo.showAll();
	}
	
	public void updateUser() {
		
	}
}
