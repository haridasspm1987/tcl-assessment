package com.tcl.activity.student.rest.repository.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "STUDENT")
@Data
@ToString(callSuper = true)
@NoArgsConstructor
public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4677807784156800961L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	@Column(name = "ID")
	private long id;
	
	
	@Column(name = "NAME", nullable = false, unique = true)
	private String name;
	
	@Column(name = "MARKS")
	private int marks;
	
	

}
