package com.tcl.activity.student.rest.service;

import java.io.Serializable;
import java.util.List;

import com.tcl.activity.student.rest.domain.StudentFilterSDO;
import com.tcl.activity.student.rest.exception.RestServiceException;
import com.tcl.activity.student.rest.repository.domain.Student;

public interface StudentService extends Serializable {
	
	public List<Student> saveStudents(List<Student> students) throws RestServiceException;
	
	public List<Student> searchStudents(StudentFilterSDO studentFilter) throws RestServiceException;

}
