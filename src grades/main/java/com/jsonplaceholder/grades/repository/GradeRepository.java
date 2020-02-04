package com.jsonplaceholder.grades.repository;

import com.jsonplaceholder.grades.entities.Grade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends CrudRepository<Grade, Integer> {

}
