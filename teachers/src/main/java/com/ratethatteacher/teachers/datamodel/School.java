package com.ratethatteacher.teachers.datamodel;

import java.util.Set;

import org.locationtech.jts.geom.Point;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="schools")
public class School {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String locationName;
	
	@Column(name = "location_point", columnDefinition = "POINT")
	private Point locationPoint;
	
	@OneToMany(mappedBy = "school", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private Set<Teacher> teachers;

	public School() {
	}

	public School(Integer id, String name, String locationName, Point locationPoint, Set<Teacher> teachers) {
		this.id = id;
		this.name = name;
		this.locationName = locationName;
		this.locationPoint = locationPoint;
		this.teachers = teachers;
	}
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLocationName() {
		return locationName;
	}

	public Point getLocationPoint() {
		return locationPoint;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}
}
