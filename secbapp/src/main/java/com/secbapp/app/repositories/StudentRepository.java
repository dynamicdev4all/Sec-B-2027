package com.secbapp.app.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.secbapp.app.models.Student;

@Repository
public class StudentRepository {

	Map<Integer, Student> db = new HashMap<Integer, Student>();
	int current = 1;
	
	//STUDENT
	public Student register(Student newStudent) {
		db.put(current, newStudent);
		current ++;
		return newStudent;
	}
	
	public Student readOne(int id) {
		return db.get(id);
	}
	
	public String login(int id, String email, String pass) {
		Student loginStudent = readOne(id);
		if(loginStudent.getEmail().equals(email) && loginStudent.getPassword().equals(pass)) {
			return "Login Success";
		}
		return "Login Failed";
	}
	
	public Student updateData(int id, Student updatedStudent) {
		if(!db.containsKey(id)) {
			System.out.println("User does not exist in the database, please register first");
			return null;
		}
		 updatedStudent.setUid(id);
		 return updatedStudent;
	}
	
	//ADMIN
	public ArrayList<Student> showAll() {
		ArrayList<Student> list = new ArrayList<Student>();
		list.addAll(db.values());
		return list;
	}
	
	public Student removeUser(int id) {
		return db.remove(id);
	}
}
