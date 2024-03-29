package com.ratethatteacher.teachers.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ratethatteacher.teachers.datamodel.Rating;
import com.ratethatteacher.teachers.datamodel.Teacher;
import com.ratethatteacher.teachers.datamodel.TeacherDto;
import com.ratethatteacher.teachers.datamodel.User;
import com.ratethatteacher.teachers.repository.RatingsRepository;
import com.ratethatteacher.teachers.repository.TeachersRepository;

@Service
public class TeachersService {
	@Autowired
	private TeachersRepository teachersRepository;
	
	@Autowired
	private RatingsRepository ratingsRepository;
	
	public TeacherDto getTeacher(Integer id) {
		Optional<Teacher> opt = teachersRepository.findById(id);
		
		if (!opt.isEmpty()) {
			Teacher teacher = opt.get();
			return new TeacherDto(teacher.getId(), teacher.getFullName()
					, teacher.getOverallRating(), teacher.getSchool().getName());
		}
		
		return null;
	}
	
	public List<TeacherDto> getTeachers(int limit, int offset) {
		Iterable<Teacher> it = teachersRepository.findAll(PageRequest.of(offset, limit, Sort.by("overallRating").descending()));
		List<TeacherDto> teachers = new ArrayList<>();
		
		StreamSupport.stream(it.spliterator(), false)
			.forEach(teacher -> teachers.add(new TeacherDto(teacher.getId(), teacher.getFullName()
					, teacher.getOverallRating(), teacher.getSchool().getName())));
		
		return teachers;
	}
	
	public List<TeacherDto> getTeachersByFullName(String fullName, int limit, int offset) {
		List<Teacher> it = teachersRepository.findByFullNameContainingWithIdx(fullName);
		
		List<TeacherDto> teachers = new ArrayList<>();
		
		StreamSupport.stream(it.spliterator(), false)
			.forEach(teacher -> teachers.add(new TeacherDto(teacher.getId(), teacher.getFullName()
					, teacher.getOverallRating(), teacher.getSchool().getName())));
		
		return teachers;
	}
	
	public Rating addRatingForTeacher(Integer userId, Integer teacherId,
			Byte educationalProwess,
			Byte emotionalImpact,
			Byte creativityBooster,
			Byte parentsInteraction,
			String comment) {
		User user = new User(userId, null, null);
		Teacher teacher = new Teacher(teacherId, null, null, null, null);
		Rating rating = new Rating(null, user, teacher, 
				educationalProwess,
				emotionalImpact,
				creativityBooster,
				parentsInteraction,
				comment);
		
		return ratingsRepository.save(rating);		
	}
}
