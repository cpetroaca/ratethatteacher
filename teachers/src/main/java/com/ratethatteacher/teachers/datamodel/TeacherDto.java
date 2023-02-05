package com.ratethatteacher.teachers.datamodel;

public class TeacherDto {
	private Integer id;
	
	private String fullName;
	
	private Float overallRating;
	
	private String schoolName;
	
	public TeacherDto(Integer id, String fullName, Float overallRating, String schoolName) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.overallRating = overallRating;
		this.schoolName = schoolName;
	}

	public Integer getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public Float getOverallRating() {
		return overallRating;
	}

	public String getSchoolName() {
		return schoolName;
	}
}
