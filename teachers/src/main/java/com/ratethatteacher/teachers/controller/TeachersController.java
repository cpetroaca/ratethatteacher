package com.ratethatteacher.teachers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ratethatteacher.teachers.datamodel.Teacher;
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
		Teacher teacher = teachersService.getTeacher(id);
		return new TeacherDto(teacher.getId(), teacher.getFullName()
				, teacher.getOverallRating(), teacher.getSchool().getName());
	}
}
