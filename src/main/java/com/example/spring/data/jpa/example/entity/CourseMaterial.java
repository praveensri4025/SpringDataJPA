package com.example.spring.data.jpa.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

	@Id
	@SequenceGenerator(
		name = "coursematerial_sequence",
		sequenceName = "coursematerial_sequence",
		allocationSize = 1)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
	    generator = "coursematerial_sequence" 	)
	private Long courseMaterialId;
	private String url;
	
	//@OneToOne //Apply One-To-One Relationship and apply Foreign key for that use @joinColumn"
	@OneToOne(        // Only Uni Directional One-To-One Relationship 
		cascade = CascadeType.ALL,
	fetch = FetchType.LAZY	
	,optional = false )
	@JoinColumn(        // For Creation of Foreign key in second table
		name = "course_id",
	    referencedColumnName = "courseId"	)
	private Course course;
}
