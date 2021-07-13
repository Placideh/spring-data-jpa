package com.placideh.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.placideh.spring.data.jpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
	List<Student> findByFirstName(String firstName);
	List<Student>findByFirstNameContaining(String name);
	List<Student> findByLastNameNotNull();
	List<Student> findByGuardianName(String guardianName);
	Student findByFirstNameAndLastName(String firstName,String lastName);
	//using JPQL(java persistence query language
	@Query("select s from Student s where s.emailId=?1")
	Student getStudentByEmailAddress(String emailId);
//	JPQL
	@Query("select s.firstName from Student s where s.emailId=?1")
	String getStudentFirstNameByEmailAddress(String emailId);
	//NativeQuery
	@Query(
			value="select * from tbl_student s where s.email_address=?1",
			nativeQuery = true
			
			)
	Student getStudentByEmailAddressNative(String emailId);
	//Native Named Param
		@Query(
				value="select * from tbl_student s where s.email_address= :emailId",
				nativeQuery = true
				
				)
	Student getStudentByEmailAddressNativeNamed(@Param("emailId") String emailId) ;
	//updating student
	@Modifying //to make it modify to the db table we add this annotation
	@Transactional //to make the comit to db
	@Query(
			value="update tbl_student set first_name=?1 where email_address=?2",
			nativeQuery=true
			)
	int updateStudentNameByEmailId(String firstName,String email);
		
		
	
	

}
