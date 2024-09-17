package com.excelr.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//RequestParam
	//PathVariable
	//RequestBody
	//Model	, ModelMap, ModelAndView  --> if data is being sent/received from a view i.e html/jsp pages
	
	@PostMapping("/saveStudentRequestParam")					//Abhishek								98.5
	public String saveStudentRequestParam(@RequestParam("sn") String studName,@RequestParam("sp") double studPer)
	{
		Student s1=new Student();
		s1.setSname(studName);  //Abhishek
		s1.setPer(studPer);		//98.5
		
		studservice.saveStudent(s1);
		return "Record Inserted Successfully";
	}
	
	
	@PostMapping("/saveStudentPathVariable/{sn}/{sp}")		//	localhost:8085/saveStudentPathVariable/Alice/78.5							98.5
	public Student saveStudentPathVariable(@PathVariable("sn") String studName,@PathVariable("sp") double studPer)
	{
		Student s1=new Student();
		s1.setSname(studName);  //Alice
		s1.setPer(studPer);		//78.5
		
		return studservice.saveStudent(s1);
		
	}
	
	@PostMapping("/saveStudentRequestBody")		//	localhost:8085/saveStudentPathVariable/Alice/78.5							98.5
	public Student saveStudentRequestBody(@RequestBody Student s1)
	{
		return studservice.saveStudent(s1);
	}
	
	@PostMapping("/saveListStudentRequestBody")		//	localhost:8085/saveStudentPathVariable/Alice/78.5							98.5
	public List<Student> saveListStudentRequestBody(@RequestBody List<Student> students)
	{
		return studservice.saveAllStudent(students);
	}
	
	@GetMapping("/getStudentByRnoUsingRequestParam")
	public Student getStudentByRnoUsingRequestParam(@RequestParam("rollno") int rno)
	{
		return studservice.getStudent(rno);
	}
	
	@GetMapping("/getStudentByRnoUsingPathVariable/{rollno}")
	public Student getStudentByRnoUsingPathVariable(@PathVariable("rollno") int rno)
	{
		return studservice.getStudent(rno);
	}
	
	@GetMapping("/getStudentByNameUsingPathVariable/{sn}")
	public List<Student> getStudentByNameUsingPathVariable(@PathVariable("sn") String studName)
	{
		return studservice.getStudentByName(studName);
	}
	
	@GetMapping("/getScholarStudents")
	public List<Student> getScholarStudents()
	{
		return studservice.getScholarStudents();
	}
	
	@DeleteMapping("/deleteStudent/{rn}")
	public String deleteStudent(@PathVariable("rn") int rno)
	{
		studservice.deleteStudent(rno);
		return "Record Deleted";
	}
	
	@PutMapping("/updateStudent/{rn}")
	public Student updateStudent(@PathVariable("rn") int rno,@RequestBody Student newStudentValues)
	{
		return studservice.updateStudent(rno,newStudentValues);
	}
	
}
