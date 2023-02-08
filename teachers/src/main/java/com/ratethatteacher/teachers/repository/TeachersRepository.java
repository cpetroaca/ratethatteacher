package com.ratethatteacher.teachers.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ratethatteacher.teachers.datamodel.Teacher;

public interface TeachersRepository extends PagingAndSortingRepository<Teacher, Integer> {
	public Optional<Teacher> findById(Integer id);
}
