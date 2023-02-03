package com.ratethatteacher.teachers.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratethatteacher.teachers.datamodel.Teacher;
import com.ratethatteacher.teachers.repository.TeachersRepository;

@Service
public class TeachersService {
	@Autowired
	private TeachersRepository teachersRepository;
	
	public Teacher getTeacher(Integer id) {
		Optional<Teacher> opt = teachersRepository.findById(id);
		
		if (!opt.isEmpty()) {
			return opt.get();
		}
		
		return null;
	}
}
