package com.excelr.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.sb.model.Student;
import com.excelr.sb.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studrepo;   //work like hibernate session

	public Student saveStudent(Student s1) {
		return studrepo.save(s1);	
	}

	public Student getStudent(int rno) {
		return studrepo.findById(rno).get();
		
	}

	public List<Student> saveAllStudent(List<Student> students) {
		return studrepo.saveAll(students);
	}

	public List<Student> getStudentByName(String studName) {
		return studrepo.findBySname(studName);
	}

	public List<Student> getScholarStudents() {
		return studrepo.searchScholarStudents();
	}

	public void deleteStudent(int rno) {
		studrepo.deleteById(rno);
	}

	public Student updateStudent(int rno, Student newStudentValues) {
		Student studentFromDb=getStudent(rno);
		studentFromDb.setPer(newStudentValues.getPer());
		studentFromDb.setSname(newStudentValues.getSname());
		return studrepo.save(studentFromDb);	
	}

}
