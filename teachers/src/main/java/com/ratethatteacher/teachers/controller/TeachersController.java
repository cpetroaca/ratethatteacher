package com.ratethatteacher.teachers.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ratethatteacher.teachers.datamodel.Rating;
import com.ratethatteacher.teachers.datamodel.TeacherDto;
import com.ratethatteacher.teachers.service.TeachersService;

@RestController
public class TeachersController {
	@Autowired
	private TeachersService teachersService;
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@GetMapping("/teachers/{id}")
	public TeacherDto getTeacher(@PathVariable Integer id) {
		return teachersService.getTeacher(id);
	}
	
	@GetMapping("/teachers")
	public List<TeacherDto> getTeachers(@RequestParam Map<String,String> allParams) {
		String fullName = allParams.get("fullName");
		Integer limit = Integer.parseInt(allParams.get("limit"));
		Integer offset = Integer.parseInt(allParams.get("offset"));
		
		if (fullName != null) {
			return teachersService.getTeachersByFullName(fullName, limit, offset);
		}
		
		
		return teachersService.getTeachers(limit, offset);
	}
	
	@PostMapping(value = "/teachers/ratings")
	public Rating addRating(@RequestParam Map<String,String> allParams) {
		Integer userId = Integer.parseInt(allParams.get("userId"));
		Integer teacherId = Integer.parseInt(allParams.get("teacherId"));
		Byte educationalProwess = Byte.parseByte(allParams.get("educationalProwess"));
		Byte emotionalImpact = Byte.parseByte(allParams.get("emotionalImpact"));
		Byte creativityBooster = Byte.parseByte(allParams.get("creativityBooster"));
		Byte parentsInteraction = Byte.parseByte(allParams.get("parentsInteraction"));
		String comment = allParams.get("comment");
		
		return teachersService.addRatingForTeacher(userId, teacherId,
				educationalProwess,
				emotionalImpact,
				creativityBooster,
				parentsInteraction,
				comment);
	}
}
	
