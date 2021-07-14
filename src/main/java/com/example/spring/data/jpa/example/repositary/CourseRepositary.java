package com.example.spring.data.jpa.example.repositary;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.data.jpa.example.entity.Course;

@Repository
public interface CourseRepositary extends JpaRepository<Course, Long> {

	Page<Course> findByTitleContaining(String title ,Pageable pageable);
}
