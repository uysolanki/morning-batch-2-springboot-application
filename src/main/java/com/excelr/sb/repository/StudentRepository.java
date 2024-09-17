package com.excelr.sb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.excelr.sb.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{
			public List<Student> findBySname(String studentName);
			
			public List<Student> findByPerGreaterThan(double studentPercentage);
			
			@Query(value="select * from student where per>=85",nativeQuery = true)
			List<Student> searchScholarStudents();
			
			
}
