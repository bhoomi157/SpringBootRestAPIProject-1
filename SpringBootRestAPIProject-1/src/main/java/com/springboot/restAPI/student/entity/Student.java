package com.springboot.restAPI.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "roll_no")
	private int rollNo;
	
	@Column(name = "email_id")
	private String emailId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailid(String emailId) {
		this.emailId = emailId;
	}
	

	public Student(int id, String name, int rollNo, String emailId) {
		
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.emailId = emailId;
	}

	public Student() {
		super();
		
	}

}
