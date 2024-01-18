package com.springboot.restAPI.student.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restAPI.student.entity.Student;
import com.springboot.restAPI.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addDetails")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		try {
			LOGGER.info(":: createStudent :: Initiated ");
			Student savedStudent = studentService.createStudent(student);
			return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.error(":: createStudent :: exception occured ", e.getMessage());
			return null;
				}
	}
	
	@GetMapping("/getDetails")
	public ResponseEntity<Student> getStudentById(@RequestParam("id")Integer id) {
		try {
			LOGGER.info(":: getStudentById :: Initiated ");
			Student student = studentService.getStudentById(id);
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(":: getStudentById :: exception occured ", e.getMessage());
			return null;
				}
	}
	
	@GetMapping("/getAllDetails")
	public ResponseEntity<List<Student>> getAllStudent() {
		try {
			LOGGER.info(":: getAllStudent :: Initiated ");
			List<Student> studentList = studentService.getAllStudent();
			return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(":: getAllStudent :: exception occured ", e.getMessage());
			return null;
				}
	}
	
	@PutMapping("/updateDetails")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		try {
			LOGGER.info(":: updateStudent :: Initiated ");
			Student existingStudent = studentService.updateStudent(student);
			return new ResponseEntity<Student>(existingStudent, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(":: updateStudent :: exception occured ", e.getMessage());
			return null;
				}
	}
	
	@DeleteMapping("/deleteDetails")
	public ResponseEntity<String> deleteStudent(@RequestParam("id")Integer id) {
		try {
			LOGGER.info(":: deleteStudent :: Initiated ");
			 studentService.deleteStudent(id);
			return new ResponseEntity<String>("Student successfully deleted!", HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(":: deleteStudent :: exception occured ", e.getMessage());
			return null;
				}
	}

}
