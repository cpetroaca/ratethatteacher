package com.ratethatteacher.teachers.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.ratethatteacher.teachers.datamodel.Teacher;

public interface TeachersRepository extends PagingAndSortingRepository<Teacher, Integer> {
	public Optional<Teacher> findById(Integer id);
	
	public Page<Teacher> findByFullNameContainingIgnoreCase(String fullName, Pageable pageable);
	
	@Query(
		value = "SELECT * FROM teachers WHERE MATCH(full_name) AGAINST(:fullName)",
		nativeQuery = true)
	public List<Teacher> findByFullNameContainingWithIdx(@Param("fullName") String fullName);
}
