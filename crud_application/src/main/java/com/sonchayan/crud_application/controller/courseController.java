package com.sonchayan.crud_application.controller;

import com.sonchayan.crud_application.model.Course;
import com.sonchayan.crud_application.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class courseController {
    @Autowired
    private courseService service;

    @PostMapping("/addcourse")
    public Course addCourse(@RequestBody Course course){
        return service.saveCourse(course);
    }
    @PostMapping("/addcourses")
    public List<Course> addCourses(@RequestBody List<Course> courses){
        return service.saveCourses(courses);
    }
    @GetMapping("/courses")
    public List<Course> findCourses(Course course){
        return service.getCourses(course);
    }
//    @GetMapping("/course/{name}")
//    public Course findCourse(@PathVariable String courseName){
//        return service.getCourseByName(courseName);
//    }
//

    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course){
        return service.updateCourse(course);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id){
        return service.deleteCourse(id);
    }


}
