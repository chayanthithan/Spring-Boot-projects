package com.sonchayan.studentManagementApplication.serviceImpl;

import com.sonchayan.studentManagementApplication.model.Student;
import com.sonchayan.studentManagementApplication.repository.StudentRepository;
import com.sonchayan.studentManagementApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;
    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> findAllStudent() {
        return repository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> opt=repository.findById(id);
        return opt.get();
    }

    @Override
    public void deleteStudentById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        Student existData=repository.findById(student.getId()).orElse(null);
        existData.setName(student.getName());
        existData.setAddress(student.getAddress());
        existData.setEmail(student.getEmail());
        existData.setClassName(student.getClassName());
        existData.setFathersName(student.getFathersName());
        return repository.save(existData);
    }
}
