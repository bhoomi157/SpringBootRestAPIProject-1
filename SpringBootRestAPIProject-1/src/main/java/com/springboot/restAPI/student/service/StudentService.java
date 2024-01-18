package com.springboot.restAPI.student.service;

import java.util.List;

import com.springboot.restAPI.student.entity.Student;

public interface StudentService {

	Student createStudent(Student student);

	Student getStudentById(Integer id);

	List<Student> getAllStudent();

	Student updateStudent(Student student);

	String deleteStudent(Integer id);

}
