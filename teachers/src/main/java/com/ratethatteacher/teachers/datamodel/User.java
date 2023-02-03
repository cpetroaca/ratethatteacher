package com.ratethatteacher.teachers.datamodel;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String fullName;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private Set<Rating> ratings;
	
	public User(Integer id, String fullName, Set<Rating> ratings) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.ratings = ratings;
	}

	public Integer getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}
}
