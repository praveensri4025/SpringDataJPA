package com.example.spring.data.jpa.example.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.data.jpa.example.entity.CourseMaterial;

@Repository
public interface CourseMaterialRepositary extends JpaRepository<CourseMaterial, Long> {


}
