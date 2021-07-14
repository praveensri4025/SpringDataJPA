package com.example.spring.data.jpa.example.repositary;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring.data.jpa.example.entity.Guardian;
import com.example.spring.data.jpa.example.entity.Student;
import com.example.spring.data.jpa.example.entity.Student.StudentBuilder;

@SpringBootTest
//@DataJpaTest // it can be used to Test the only Repositary Layer 
class StudentRepositaryTest {

	// Craete an Object
	@Autowired
	private StudentRepositary studentRepositary;

	/*
	 * @Test public void saveStudent() { Student student =
	 * Student.builder().emailId("praveenkotha01@gmail.com").firstName("praveen").
	 * lastName("kotha") // .guardianName("Lingam") //
	 * .guardianEmail("lingam@gmail.com") // .guardianMobile("9640280321") .build();
	 * 
	 * studentRepositary.save(student); }
	 * 
	 * @Test public void saveStudentWithGuardian() {
	 * 
	 * Guardian guardian =
	 * Guardian.builder().name("Raju").email("Raju@gmail.com").mobile("99999999999")
	 * .build(); Student student =
	 * Student.builder().firstName("Naveen").lastName("Kokmati").emailId(
	 * "naveen01@gmail.com") .guardian(guardian).build();
	 * studentRepositary.save(student); }
	 * 
	 * @Test public void printAllStudent() {
	 * 
	 * List<Student> students = studentRepositary.findAll();
	 * 
	 * System.out.println("students = " + students); }
	 * 
	 * @Test public void printStudentByFirstName() { List<Student> students =
	 * studentRepositary.findByFirstName("Naveen");
	 * 
	 * System.out.println("students =" + students); }
	 * 
	 * @Test public void printStudentByFirstNameContaining() { List<Student>
	 * students = studentRepositary.findByFirstNameContaining("aveen");
	 * 
	 * System.out.println("students =" + students);
	 * 
	 * }
	 * 
	 * @Test public void printStudentBasedOnGuardianName() {
	 * 
	 * List<Student> students = studentRepositary.findByGuardianName("Raju");
	 * 
	 * System.out.println("students =" + students);
	 * 
	 * }
	 */

	@Test
	public void printgetStudentByEmailAddress() {

		Student student = studentRepositary.getStudentByEmailAddress("praveenkotha4025@gmail.com");
		System.out.println("student =" + student);

	}
	
	@Test
	public void printStudentFirstNameByEmailAddress() {
		String firstName =
				studentRepositary.getStudentFirstNameByEmailAddress("praveenkotha4025@gmail.com");
		System.out.println("firstName =" + firstName);

	}
	
	@Test
	public void printgetStudentByEmailAddressNative() {

		Student student = studentRepositary.getStudentByEmailAddressNative("praveenkotha4025@gmail.com");
		System.out.println("student =" + student);

	}
	
	@Test
	public void printgetStudentByEmailAddressNativeParam() {

		Student student = 
				studentRepositary.getStudentByEmailAddressNativeParam("praveenkotha4025@gmail.com");
		System.out.println("student =" + student);

	}
	
	@Test
	public void updateStudentNameByEmailIdTest() {
		studentRepositary.updateStudentNameByEmailId("PraveenKumarKotha", "praveenkotha4025@gmail.com");
	}

}
