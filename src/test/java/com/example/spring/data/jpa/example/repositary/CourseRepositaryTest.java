package com.example.spring.data.jpa.example.repositary;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.example.spring.data.jpa.example.entity.Course;
import com.example.spring.data.jpa.example.entity.Student;
import com.example.spring.data.jpa.example.entity.Teacher;

@SpringBootTest
public class CourseRepositaryTest {

	@Autowired
	private CourseRepositary courseRepositary;
	
	@Test
	public void printCourses() {
		
		List<Course> courses = courseRepositary.findAll();
		
		System.out.println("courses = " + courses);
	}
	
	@Test
	public void saveCoursesWithTeacher()
	{
		Teacher teacher = Teacher.builder()
				.firstName("Ramu")
				.lastName("Virat")
				.build();
		
		Course course =Course.builder()
				.title("Python")
				.credit(9)
				.teacher(teacher)
				.build();
		courseRepositary.save(course);
	}
	
	@Test
    public void findAllPagination(){
        Pageable firstPagewithThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = 
                PageRequest.of(1,2);
        
        List<Course> courses =
        		courseRepositary.findAll(secondPageWithTwoRecords)
                        .getContent();
        
        long totalElements =
                courseRepositary.findAll(secondPageWithTwoRecords)
                .getTotalElements();

        long totalPages =
                courseRepositary.findAll(secondPageWithTwoRecords)
                .getTotalPages();

        System.out.println("totalPages = " + totalPages);
        
        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);
    }
	
	@Test
    public void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                        );
        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                        .descending()
                        .and(Sort.by("credit"))
                );
        
        List<Course> courses
                = courseRepositary.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }
	@Test
    public void printfindByTitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses =
                courseRepositary.findByTitleContaining(
                        "DB",
                        firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }

	@Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Lizze")
                .lastName("Morgan")
                .build();

        Student student = Student.builder()
                .firstName("Abhishek")
                .lastName("Singh")
                .emailId("abhishek@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepositary.save(course);
    }
}
