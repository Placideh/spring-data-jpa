package com.placideh.spring.data.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.placideh.spring.data.jpa.entity.Student;
@SpringBootTest
class StudentRepositoryTest {
	@Autowired
	StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		Student student=Student.builder()
				.emailId("placideh@gmail.com")
				.firstName("Placideh")
				.lastName("Hakiz")
				.guardianName("Maman")
				.guardianEmail("maman@gmail.com")
				.guardianMobile("0783027144")
				.build();
		studentRepository.save(student);
	}
	@Test
	public void printAllStudent() {
		List<Student> studentList=studentRepository.findAll();
		System.out.println("StudentList:"+studentList);
		
	}

}
