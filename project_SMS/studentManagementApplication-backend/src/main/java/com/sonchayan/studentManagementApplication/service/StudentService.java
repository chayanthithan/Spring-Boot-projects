package com.sonchayan.studentManagementApplication.service;

import com.sonchayan.studentManagementApplication.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);

    List<Student> findAllStudent();

    public Student getStudentById(Long id);
    public void deleteStudentById(Long id);

   public Student updateStudent(Student student);
}
