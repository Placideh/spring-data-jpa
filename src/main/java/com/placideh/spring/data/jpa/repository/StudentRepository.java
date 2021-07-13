package com.placideh.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placideh.spring.data.jpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

}
