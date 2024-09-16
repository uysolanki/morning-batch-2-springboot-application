package com.excelr.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.sb.model.Student;
import com.excelr.sb.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studservice;
	
	@PostMapping("/welcome")
	public String greet()
	{
		return "Welcome to Excelr FSD Program, Baner Pune";
	}

	@PostMapping("/savehard")
	public String saveHard()
	{
		Student s1=new Student();
		s1.setSname("AliceSB");
		s1.setPer(78.88);
		
		studservice.saveStudent(s1);
		return "Record Inserted Successfully";
	}
	
	@GetMapping("/getStudent")
	public Student getSingleStudentDetails()
	{
		int rno=1;
		return studservice.getStudent(rno);
	}
}
