package com.sonchayan.crud_application.service;

import com.sonchayan.crud_application.model.Course;
import com.sonchayan.crud_application.repository.courseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class courseService {
    @Autowired
    private courseRepository courseRepo;
    //create-----------------------------------------------
    public Course saveCourse(Course course){
        return courseRepo.save(course);
    }
    public List<Course> saveCourses(List<Course> course){
        return courseRepo.saveAll(course);
    }
    //find--------------------------------------------------
    public List<Course> getCourses(Course course){
        return courseRepo.findAll();
    }



    /////////////////////
    //delete-----------------------------------------
    public String deleteCourse(int id){
        courseRepo.deleteById(id);
        return "successfully deleted!!!!!!";
    }

    //update----------------------------------------------
    public Course updateCourse(Course course){
        Course existingCourse=courseRepo.findById(course.getId()).orElse(null);
        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setCourseCode(course.getCourseCode());
        existingCourse.setCourseCredit(course.getCourseCredit());
        existingCourse.setCourseIncharge(course.getCourseIncharge());
        return courseRepo.save(existingCourse);
    }
}
