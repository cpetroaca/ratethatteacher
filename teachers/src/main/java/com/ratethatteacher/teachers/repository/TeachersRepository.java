package com.ratethatteacher.teachers.repository;

import org.springframework.data.repository.CrudRepository;

import com.ratethatteacher.teachers.datamodel.Teacher;

public interface TeachersRepository extends CrudRepository<Teacher, Integer> {

}
