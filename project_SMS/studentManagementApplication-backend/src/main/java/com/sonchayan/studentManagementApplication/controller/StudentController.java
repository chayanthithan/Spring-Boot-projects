package com.sonchayan.studentManagementApplication.controller;

import com.sonchayan.studentManagementApplication.model.Student;
import com.sonchayan.studentManagementApplication.service.StudentService;
import com.sonchayan.studentManagementApplication.serviceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/student")
    public Student registerStudent(@RequestBody Student student){
        return service.saveStudent(student);

    }
    @GetMapping("/students")
    public List<Student> getAllStudent(){
        List<Student> list=service.findAllStudent();
        return list;
    }
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") Long id){
        return service.getStudentById(id);

    }
    @DeleteMapping("/student/{id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable("id") Long id){
//        return new ResponseEntity<>(new Student,HttpStatus.OK);
            service.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/student/{id}")
    public Student updateStudent(@RequestBody Student student){
        return service.updateStudent(student);
    }


}
