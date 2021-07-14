package com.example.spring.data.jpa.example.repositary;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring.data.jpa.example.entity.Course;
import com.example.spring.data.jpa.example.entity.Teacher;

@SpringBootTest
public class TeacherRepositaryTest {

	@Autowired
	private TeacherRepositary teacherRepositary;
	
	@Test
	public void saveTeacher() {
		Course courseDBA = Course.builder()
				.title("DBA")
				.credit(10)
				.build();
		Course courseJava = Course.builder()
				.title("Java")
				.credit(8)
				.build();
		Course courseSpring = Course.builder()
				.title("Spring")
				.credit(9)
				.build();
		
		Teacher teacher = Teacher.builder()
				.firstName("Devadas")
				.lastName("Kotha")
				.courses(List.of(courseDBA,courseJava,courseSpring))
				.build();
		
	teacherRepositary.save(teacher);
	}
}
