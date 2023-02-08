package com.ratethatteacher.teachers.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
		return teachersService.getTeacher(id);
	}
	
	@GetMapping("/teachers")
	public List<TeacherDto> getTeachers(@RequestParam int limit, @RequestParam int offset) {
		return teachersService.getTeachers(limit, offset);
	}
}
