package com.ratethatteacher.teachers.datamodel;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ratings")
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teacher_id", nullable = false)
	private Teacher teacher;
	
	private Byte educationalProwess;
	
	private Byte emotionalImpact;
	
	private Byte creativityBooster;
	
	private Byte parentsInteraction;
	
	private String comment;

	public Rating() {
	}

	public Rating(Integer id, User user, Teacher teacher, Byte educationalProwess, Byte emotionalImpact,
			Byte creativityBooster, Byte parentsInteraction, String comment) {
		super();
		this.id = id;
		this.user = user;
		this.teacher = teacher;
		this.educationalProwess = educationalProwess;
		this.emotionalImpact = emotionalImpact;
		this.creativityBooster = creativityBooster;
		this.parentsInteraction = parentsInteraction;
		this.comment = comment;
	}

	public Integer getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public Byte getEducationalProwess() {
		return educationalProwess;
	}

	public Byte getEmotionalImpact() {
		return emotionalImpact;
	}

	public Byte getCreativityBooster() {
		return creativityBooster;
	}

	public Byte getParentsInteraction() {
		return parentsInteraction;
	}

	public String getComment() {
		return comment;
	}
}
