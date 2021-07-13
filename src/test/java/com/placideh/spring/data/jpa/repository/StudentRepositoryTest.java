package com.placideh.spring.data.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.placideh.spring.data.jpa.entity.Guardian;
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
//				.guardianName("Maman")
//				.guardianEmail("maman@gmail.com")
//				.guardianMobile("0783027144")
				.build();
		studentRepository.save(student);
	}
	@Test
	public void saveStudentWithGuardian() {
		Guardian guardian=Guardian.builder()
				.name("tonton")
				.email("tonton@gmail.com")
				.mobile("0788555913")
				.build();
		Student student=Student.builder()
				.firstName("Yannick")
				.lastName("kobe")
				.emailId("kobe@gmail.com")
				.guardian(guardian)
				.build();
		studentRepository.save(student);
	}
	@Test
	public void printAllStudent() {
		List<Student> studentList=studentRepository.findAll();
		System.out.println("StudentList:"+studentList);
		
	}
	@Test
	public void printStudentByFirstName() {
		List<Student> students=studentRepository.findByFirstName("Placideh");
		System.out.println(students);
	}
	@Test
	public void printStudentByFirstNameContaining() {
		List<Student> students=studentRepository.findByFirstNameContaining("a");
		System.out.println(students);
	}
	@Test 
	public void printStudentBaseOnGuardianName() {
		List<Student> students=studentRepository.findByGuardianName("maman");
		System.out.println(students);
	}
	@Test
	public void printStudentByFirstNameAndLastName() {
		Student student=studentRepository.findByFirstNameAndLastName("Yannick","Kobe");
		System.out.println(student);
	}
	@Test 
	public void printgetStudentByEmailAddress() {
		Student student=studentRepository.getStudentByEmailAddress("placideh@gmail.com");
		System.out.println(student);
	}
	@Test
	public void printgetStudentFirstNameByEmailAddress() {
		String studentFirstName=studentRepository.getStudentFirstNameByEmailAddress("placideh@gmail.com");
		System.out.println(studentFirstName);
	}
	
	@Test 
	public void printgetStudentByEmailAddressNative() {
		Student student=studentRepository.getStudentByEmailAddressNative("kobe@gmail.com");
		System.out.println(student);
	}

	@Test 
	public void printgetStudentByEmailAddressNativeNamed() {
		Student student=studentRepository.getStudentByEmailAddressNativeNamed("kobe@gmail.com");
		System.out.println(student);
	}
	
	//updating Test
	@Test
	public void updateStudentNameByEmailIdTest() {
		int result=studentRepository.updateStudentNameByEmailId("Placid", "placideh@gmail.com");
		if(result>0) System.out.println("updated");
		
	}
	

	

}
