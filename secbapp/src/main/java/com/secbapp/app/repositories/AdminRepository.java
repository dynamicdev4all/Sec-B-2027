package com.secbapp.app.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.secbapp.app.models.Admin;
import com.secbapp.app.models.Student;

public class AdminRepository {
	
	@Autowired
	StudentRepository studentRepo;
	Map<Integer, Admin> db = new HashMap<Integer, Admin>();
	int current = 1;
	
	//STUDENT
	public Admin register(Admin newAdmin) {
		db.put(current, newAdmin);
		current ++;
		return newAdmin;
	}
	
	public Admin readOne(int id) {
		return db.get(id);
	}
	
	public String login(int id, String email, String pass) {
		Admin loginAdmin = readOne(id);
		if(loginAdmin.getEmail().equals(email) && loginAdmin.getPass().equals(pass)) {
			return "Login Success";
		}
		return "Login Failed";
	}
	
	//ADMIN
	public ArrayList<Student> showAll() {
		ArrayList<Student> list = new ArrayList<Student>();
		list.addAll(studentRepo.db.values());
		return list;
	}
	
	public Student removeUser(int id) {
		return studentRepo.db.remove(id);
	}
}
