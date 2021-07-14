package com.example.spring.data.jpa.example.repositary;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.spring.data.jpa.example.entity.Student;

//By using this Spring will understand this is Repositary Interface

@Repository
public interface StudentRepositary extends JpaRepository<Student, Long> {

	List<Student> findByFirstName(String firstName);

	List<Student> findByFirstNameContaining(String name);

	List<Student> findByLastNameNotNull();

	List<Student> findByGuardianName(String guardianName);

	Student findByFirstNameAndLastName(String firstName, String lastName);
	// JPQL It is created based on the Class not a Table in the DB

	@Query("select s from Student s where s.emailId =?1") // This is based on Class not a Table
	Student getStudentByEmailAddress(String emailId);

	@Query("select s.firstName from Student s where s.emailId =?1") // This is based on Class not a Table
	String getStudentFirstNameByEmailAddress(String emailId);

	// Native SQL Queries

	@Query(
			value = "SELECT * FROM schooldb.tbl_student s where s.email_address = ?1", 
			nativeQuery = true
			)
	Student getStudentByEmailAddressNative(String emailId);
	
	
	//Native Query Named parameters
	
	@Query(
			value = "SELECT * FROM schooldb.tbl_student s where s.email_address = :emailId", 
			nativeQuery = true
			)
	Student getStudentByEmailAddressNativeParam(
			@Param("emailId") String emailId);
	
	// Update the Data in the Db
	
	@Modifying
	@Transactional
	@Query(
		value = "update tbl_student set first_name =?1 where email_address =?2" ,
		nativeQuery = true )
	int updateStudentNameByEmailId(String firstName ,String emailId);
	
}