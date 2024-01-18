package com.springboot.restAPI.student.serviceimpl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restAPI.student.entity.Student;
import com.springboot.restAPI.student.repository.StudentRepository;
import com.springboot.restAPI.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {

		LOGGER.info("createStudent method :: initiated");
		Student savedStudent = studentRepository.save(student);
		return savedStudent;
	}

	@Override
	public Student getStudentById(Integer id) {

		LOGGER.info("getStudentById method :: initiated");
		Student Student = studentRepository.findById(id).get();
		return Student;
	}

	@Override
	public List<Student> getAllStudent() {

		LOGGER.info("getAllStudent method :: initiated");
		List<Student> studentList = studentRepository.findAll();
		return studentList;
	}

	@Override
	public Student updateStudent(Student searchstudent) {

		LOGGER.info("updateStudent method :: initiated");
		Student existingStudent = studentRepository.findById(searchstudent.getId()).get();
		existingStudent.setId(searchstudent.getId());
		existingStudent.setName(searchstudent.getName());
		existingStudent.setRollNo(searchstudent.getRollNo());
		existingStudent.setEmailid(searchstudent.getEmailId());
		Student updatedStudent = studentRepository.save(searchstudent);
		return updatedStudent;
	}

	@Override
	public String deleteStudent(Integer id) {

		LOGGER.info("deleteStudent method :: initiated");
		studentRepository.deleteById(id);
		return "Student successfully deleted!";
	}

}
