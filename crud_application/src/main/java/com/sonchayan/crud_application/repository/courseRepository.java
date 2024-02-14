package com.sonchayan.crud_application.repository;

import com.sonchayan.crud_application.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface courseRepository extends JpaRepository<Course,Integer> {

//    Course findByName(String name);
//
//    Course findByCode(String name);

//    List<Course> findByName(String name);
}
