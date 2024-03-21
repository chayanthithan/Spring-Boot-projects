package com.sonchayan.studentManagementApplication.repository;

import com.sonchayan.studentManagementApplication.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

//    private Service

}
