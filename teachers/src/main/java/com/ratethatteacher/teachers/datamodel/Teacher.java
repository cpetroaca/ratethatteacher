package com.ratethatteacher.teachers.datamodel;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="teachers")
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String fullName;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "schoolId", nullable = false)
	private School school;
	
	private Float overallRating;
	
	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private Set<Rating> ratings;

	public Teacher(Integer id, String fullName, School school, Float overallRating, Set<Rating> ratings) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.school = school;
		this.overallRating = overallRating;
		this.ratings = ratings;
	}

	public Integer getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public School getSchool() {
		return school;
	}

	public Float getOverallRating() {
		return overallRating;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}
}
