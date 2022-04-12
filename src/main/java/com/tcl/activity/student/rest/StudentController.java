package com.tcl.activity.student.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.tcl.activity.student.rest.domain.StudentFilterSDO;
import com.tcl.activity.student.rest.exception.RestServiceException;
import com.tcl.activity.student.rest.repository.domain.Student;
import com.tcl.activity.student.rest.service.StudentService;
import com.tcl.activity.student.rest.util.RestApiError;
import com.tcl.activity.student.rest.util.RestApiErrorUtil;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping("")
	public String hello() {
		return "hello";
	}

	@PostMapping(path = "/bulkcreate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createStudents(@RequestBody List<Student> students) {
		HttpHeaders headers = new HttpHeaders();
		try {
			students = service.saveStudents(students);
			return new ResponseEntity<>(students, headers, HttpStatus.CREATED);
		} catch (HttpClientErrorException e) {
			RestApiError error = new RestApiError(HttpStatus.BAD_REQUEST, "Bad Request for the API");
			return new ResponseEntity<>(error, headers, HttpStatus.BAD_REQUEST);
		} catch (RestServiceException e) {
			log.info("Exception in [createStudents] method due to: {} for the request: {}", e.getMessage(), students);
			RestApiError error = RestApiErrorUtil.createRestApiError(e);
			error.setStatus(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<>(error, headers, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(path = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchStudents(@RequestBody StudentFilterSDO studentfilter) {
		HttpHeaders headers = new HttpHeaders();
		try {
			List<Student> students = service.searchStudents(studentfilter);
			return new ResponseEntity<>(students, headers, HttpStatus.ACCEPTED);
		} catch (HttpClientErrorException e) {
			RestApiError error = new RestApiError(HttpStatus.BAD_REQUEST, "Bad Request for the API");
			return new ResponseEntity<>(error, headers, HttpStatus.BAD_REQUEST);
		} catch (RestServiceException e) {
			log.info("Exception in [searchStudents] method due to: {} for the request: {}", e.getMessage(), studentfilter);
			RestApiError error = RestApiErrorUtil.createRestApiError(e);
			error.setStatus(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<>(error, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
