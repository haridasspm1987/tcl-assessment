package com.tcl.activity.student.rest.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tcl.activity.student.rest.repository.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	public List<Student> findByMarksBetween(int min, int max);
	
	public List<Student> findByMarksBetween(int min, int max, Sort sort);
	
	

}
