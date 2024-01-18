package com.springboot.restAPI.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restAPI.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

	
}
