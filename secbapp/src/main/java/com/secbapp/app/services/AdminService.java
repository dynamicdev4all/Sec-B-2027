package com.secbapp.app.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.secbapp.app.models.Admin;
import com.secbapp.app.models.Student;
import com.secbapp.app.repositories.AdminRepository;

public class AdminService {
	
	@Autowired
	AdminRepository repo;

	public Student deleteAccount(int id) {
		return repo.removeUser(id);
	}
	
	public ArrayList<Student> viewAll() {
		return repo.showAll();
	}
	
	public void updateUser() {
		
	}
	public String adminLogin(int id, String email, String pass) {
		return repo.login(id, email, pass);
	}
	
	public Admin adminRegister(Admin newAdmin) {
		return repo.register(newAdmin);
	}
}
