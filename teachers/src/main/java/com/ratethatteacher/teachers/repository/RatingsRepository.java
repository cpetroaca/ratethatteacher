package com.ratethatteacher.teachers.repository;

import org.springframework.data.repository.CrudRepository;
import com.ratethatteacher.teachers.datamodel.Rating;

public interface RatingsRepository extends CrudRepository<Rating, Integer> {
}
