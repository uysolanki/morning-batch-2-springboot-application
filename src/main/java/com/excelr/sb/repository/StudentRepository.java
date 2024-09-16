package com.excelr.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.sb.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{

}
