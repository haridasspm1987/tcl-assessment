package com.tcl.activity.student.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tcl.activity.student.rest.domain.Ordering;
import com.tcl.activity.student.rest.domain.StudentFilterSDO;
import com.tcl.activity.student.rest.exception.RestServiceException;
import com.tcl.activity.student.rest.repository.StudentRepository;
import com.tcl.activity.student.rest.repository.domain.Student;
import com.tcl.activity.student.rest.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3979581809672737919L;
	
	@Autowired
	StudentRepository repository;

	@SuppressWarnings("deprecation")
	@Override
	public List<Student> saveStudents(List<Student> students) throws RestServiceException {
		try {
			return repository.saveAll(students);
		} catch (Exception e) {
			throw new RestServiceException("BULK_STUDENT_CREATION_FAIL", "Bulk student creation failed due ! ");
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Student> searchStudents(StudentFilterSDO studentFilter) throws RestServiceException {
		try {
			if(StringUtils.hasLength(studentFilter.getSortBy())) {
				return repository.findByMarksBetween(studentFilter.getMin(), studentFilter.getMax(), Sort.by(formOrder(studentFilter), studentFilter.getSortBy()));
			}
			return repository.findByMarksBetween(studentFilter.getMin(), studentFilter.getMax());
		} catch (Exception e) {
			throw new RestServiceException("STUDENT_SEARCH_FAILED", "Student search failed due to " + e.getMessage());
		}
	}
	
	private Sort.Direction formOrder(StudentFilterSDO studentFilter) {
		if(studentFilter.getOrderBy() != null && studentFilter.getOrderBy().equals(Ordering.DESCENDING)) {
			return Sort.Direction.DESC;
		} 
		return Sort.Direction.ASC;
	}


}
