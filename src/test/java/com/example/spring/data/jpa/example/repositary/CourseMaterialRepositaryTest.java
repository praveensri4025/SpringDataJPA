package com.example.spring.data.jpa.example.repositary;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring.data.jpa.example.entity.Course;
import com.example.spring.data.jpa.example.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositaryTest {

	@Autowired
	private CourseMaterialRepositary courseMaterialRepositary;
	
	@Test
	public void saveCourseMaterial() {
		
		Course course = Course.builder()
				.title("JAVA-Microservices")
				.credit(10)
				.build();
		
		CourseMaterial courseMaterial =
				CourseMaterial.builder()
				.url("www.facebook.com")
				.course(course)
				.build();
				
		courseMaterialRepositary.save(courseMaterial);
	}
	
	@Test
	public void printAllCourseMaterails() {
		List<CourseMaterial> courseMaterials=courseMaterialRepositary.findAll();
		
		System.out.println("courseMaterials = " + courseMaterials);
	}
	
	
	
	
	
}
