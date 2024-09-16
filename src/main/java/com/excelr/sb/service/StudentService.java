package com.excelr.sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.sb.model.Student;
import com.excelr.sb.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studrepo;   //work like hibernate session

	public void saveStudent(Student s1) {
		studrepo.save(s1);	
	}

	public Student getStudent(int rno) {
		return studrepo.findById(rno).get();
		
	}

}
