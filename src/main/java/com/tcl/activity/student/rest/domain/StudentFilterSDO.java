package com.tcl.activity.student.rest.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentFilterSDO {

	private int min;

	private int max;

	private Ordering orderBy;
	
	private String sortBy;

}
